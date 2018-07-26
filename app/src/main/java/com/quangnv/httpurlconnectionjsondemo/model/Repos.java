package com.quangnv.httpurlconnectionjsondemo.model;

public class Repos {
    private long mId;
    private String mName;
    private String mFullName;
    private Owner mOwner;
    private boolean mPrivate;
    private String mDescription;
    private boolean mFork;
    private License mLicense;
    private String mDefaultBranch;

    public static final class ReposEntry {
        public static final String NAME_ID = "id";
        public static final String NAME_NAME = "name";
        public static final String NAME_FULL_NAME = "full_name";
        public static final String NAME_OWNER = "owner";
        public static final String NAME_PRIVATE = "private";
        public static final String NAME_DESCRIPTION = "description";
        public static final String NAME_FORK = "fork";
        public static final String NAME_LICENSE = "license";
        public static final String NAME_DEFAULT_BRANCH = "default_branch";
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Owner getOwner() {
        return mOwner;
    }

    public void setOwner(Owner owner) {
        mOwner = owner;
    }

    public boolean isPrivate() {
        return mPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        mPrivate = aPrivate;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public boolean isFork() {
        return mFork;
    }

    public void setFork(boolean fork) {
        mFork = fork;
    }

    public License getLicense() {
        return mLicense;
    }

    public void setLicense(License license) {
        mLicense = license;
    }

    public String getDefaultBranch() {
        return mDefaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        mDefaultBranch = defaultBranch;
    }
}
