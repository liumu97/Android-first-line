package com.example.cameraalbumtest;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5dd33c5f570df35aaf00087b", "yhs", UMConfigure.DEVICE_TYPE_PHONE, null);
        UMConfigure.setLogEnabled(true);
        MobclickAgent.setPageCollectionMode(MobclickAgent.PageMode.AUTO);
    }
}
