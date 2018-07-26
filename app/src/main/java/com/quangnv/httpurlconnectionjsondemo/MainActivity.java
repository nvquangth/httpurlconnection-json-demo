package com.quangnv.httpurlconnectionjsondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.quangnv.httpurlconnectionjsondemo.model.Repos;
import com.quangnv.httpurlconnectionjsondemo.model.ReposTask;
import com.quangnv.httpurlconnectionjsondemo.model.ReposTaskListener;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ReposTaskListener {

    private final String URL = "https://api.github.com/users/google/repos";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ReposTask task = new ReposTask(this);

        task.execute(URL);

    }

    @Override
    public void onErrorTask(Exception e) {
        e.printStackTrace();
    }

    @Override
    public void onProgressUpdateTask(Repos repos) {

    }

    @Override
    public void onCompleteTask(List<Repos> reposs) {
        Log.d("repos_size", reposs.size() + "");
    }
}
