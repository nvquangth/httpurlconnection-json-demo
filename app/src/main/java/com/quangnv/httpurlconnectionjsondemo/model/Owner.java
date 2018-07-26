package com.quangnv.httpurlconnectionjsondemo.model;

public class Owner {
    private String mLogin;
    private long mId;
    private String mNodeId;
    private String mAvatarUrl;
    private String mUrl;
    private String mFollowsUrl;
    private boolean mSiteAdmin;

    public static class OwnerEntry {
        public static final String NAME_LOGIN = "login";
        public static final String NAME_ID = "id";
        public static final String NAME_NODE_ID = "node_id";
        public static final String NAME_AVATAR_URL = "avatar_url";
        public static final String NAME_URL = "url";
        public static final String NAME_FOLLOW_URL = "followers_url";
        public static final String NAME_SITE_ADMIN = "site_admin";
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getNodeId() {
        return mNodeId;
    }

    public void setNodeId(String nodeId) {
        mNodeId = nodeId;
    }

    public String getAvatarUrl() {
        return mAvatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        mAvatarUrl = avatarUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getFollowsUrl() {
        return mFollowsUrl;
    }

    public void setFollowsUrl(String followsUrl) {
        mFollowsUrl = followsUrl;
    }

    public boolean isSiteAdmin() {
        return mSiteAdmin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        mSiteAdmin = siteAdmin;
    }
}
