package com.quangnv.httpurlconnectionjsondemo.model;

public class License {
    private String mKey;
    private String mName;
    private String mSpdxId;
    private String mUrl;
    private String mNodeId;

    public static class LicenseEntry {
        public static final String NAME_KEY = "key";
        public static final String NAME_NAME = "name";
        public static final String NAME_SPDX_ID = "spdx_id";
        public static final String NAME_URL = "url";
        public static final String NAME_NODE_ID = "node_id";
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getSpdxId() {
        return mSpdxId;
    }

    public void setSpdxId(String spdxId) {
        mSpdxId = spdxId;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getNodeId() {
        return mNodeId;
    }

    public void setNodeId(String nodeId) {
        mNodeId = nodeId;
    }
}
