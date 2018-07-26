package com.quangnv.httpurlconnectionjsondemo.model;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ReposTask extends AsyncTask<String, Repos, List<Repos>> {

    private static final String HTTP_METHOD = "GET";

    private ReposTaskListener mListener;
    private List<Repos> mRepos;

    public ReposTask(ReposTaskListener listener) {
        mListener = listener;
        mRepos = new ArrayList<>();
    }

    @Override
    protected List<Repos> doInBackground(String... strings) {

        String s = getApi(strings[0]);

        if (!s.isEmpty()) {
            mRepos =  parseJson(s);
        }

        return mRepos;
    }

    @Override
    protected void onProgressUpdate(Repos... values) {
        super.onProgressUpdate(values);
        mListener.onProgressUpdateTask(values[0]);
        mRepos.add(values[0]);
    }

    @Override
    protected void onPostExecute(List<Repos> repos) {
        super.onPostExecute(repos);
        mListener.onCompleteTask(repos);
    }

    private String getApi(String url) {
        try {

            URL mUrl = new URL(url);
            HttpURLConnection httpConnection = (HttpURLConnection) mUrl.openConnection();
            httpConnection.setRequestMethod(HTTP_METHOD);
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            mListener.onErrorTask(e);
        }
        return null;
    }

    private List<Repos> parseJson(String s) {

        List<Repos> reposs = new ArrayList<>();

        try {
            JSONArray jsonArray = new JSONArray(s);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                Repos repos = new Repos();

                repos.setId(jsonObject.getLong(Repos.ReposEntry.NAME_ID));
                repos.setName(jsonObject.getString(Repos.ReposEntry.NAME_NAME));
                repos.setFullName(jsonObject.getString(Repos.ReposEntry.NAME_FULL_NAME));
                repos.setPrivate(jsonObject.getBoolean(Repos.ReposEntry.NAME_PRIVATE));
                repos.setDescription(jsonObject.getString(Repos.ReposEntry.NAME_DESCRIPTION));
                repos.setFork(jsonObject.getBoolean(Repos.ReposEntry.NAME_FORK));
                repos.setDefaultBranch(jsonObject.getString(Repos.ReposEntry.NAME_DEFAULT_BRANCH));

                if (!jsonObject.isNull(Repos.ReposEntry.NAME_OWNER)) {
                    JSONObject ownerJsonObject = jsonObject.getJSONObject(Repos.ReposEntry.NAME_OWNER);
                    Owner owner = new Owner();
                    owner.setLogin(ownerJsonObject.getString(Owner.OwnerEntry.NAME_LOGIN));
                    owner.setId(ownerJsonObject.getLong(Owner.OwnerEntry.NAME_ID));
                    owner.setNodeId(ownerJsonObject.getString(Owner.OwnerEntry.NAME_NODE_ID));
                    owner.setAvatarUrl(ownerJsonObject.getString(Owner.OwnerEntry.NAME_AVATAR_URL));
                    owner.setUrl(ownerJsonObject.getString(Owner.OwnerEntry.NAME_URL));
                    owner.setFollowsUrl(ownerJsonObject.getString(Owner.OwnerEntry.NAME_FOLLOW_URL));
                    owner.setSiteAdmin(ownerJsonObject.getBoolean(Owner.OwnerEntry.NAME_SITE_ADMIN));
                    repos.setOwner(owner);
                }

                if (!jsonObject.isNull(Repos.ReposEntry.NAME_LICENSE)) {
                    JSONObject licenseJsonObject = jsonObject.getJSONObject(Repos.ReposEntry.NAME_LICENSE);
                    License license = new License();
                    license.setKey(licenseJsonObject.getString(License.LicenseEntry.NAME_KEY));
                    license.setName(licenseJsonObject.getString(License.LicenseEntry.NAME_NAME));
                    license.setSpdxId(licenseJsonObject.getString(License.LicenseEntry.NAME_SPDX_ID));
                    license.setUrl(licenseJsonObject.getString(License.LicenseEntry.NAME_URL));
                    license.setNodeId(licenseJsonObject.getString(License.LicenseEntry.NAME_NODE_ID));
                    repos.setLicense(license);
                }

                reposs.add(repos);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return reposs;
    }



}
