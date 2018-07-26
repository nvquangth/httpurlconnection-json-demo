package com.quangnv.httpurlconnectionjsondemo.model;

import java.util.List;

public interface ReposTaskListener {
    void onErrorTask(Exception e);
    void onProgressUpdateTask(Repos repos);
    void onCompleteTask(List<Repos> reposs);
}
