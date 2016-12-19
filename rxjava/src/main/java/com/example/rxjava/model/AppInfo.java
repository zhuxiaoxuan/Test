package com.example.rxjava.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/12/19.
 */
public class AppInfo {

    private String appName;
    private Drawable appIcon;
    private long lastUpdateTime;


    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "appName='" + appName + '\'' +
                '}';
    }
}
