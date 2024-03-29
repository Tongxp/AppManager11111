package com.zhou.appmanager.model;

import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class AppInfo implements Parcelable{
    private String appName;
    private String packageName;
    private Drawable appIcon;
    private String[] permissionInfos;
    private ApplicationInfo applicationInfo;

    public AppInfo() {
    }

    protected AppInfo(Parcel in) {
        appName = in.readString();
        packageName = in.readString();
        //appIcon = in.readParcelable(Bitmap.class.getClassLoader());
        permissionInfos = in.createStringArray();
        applicationInfo = in.readParcelable(ApplicationInfo.class.getClassLoader());
    }

    public static final Creator<AppInfo> CREATOR = new Creator<AppInfo>() {
        @Override
        public AppInfo createFromParcel(Parcel in) {
            return new AppInfo(in);
        }

        @Override
        public AppInfo[] newArray(int size) {
            return new AppInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(appName);
        dest.writeString(packageName);
        //dest.writeParcelable(appIcon,flags);
        dest.writeStringArray(permissionInfos);
        dest.writeParcelable(applicationInfo,flags);
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", appIcon=" + appIcon +
                ", permissionInfos=" + Arrays.toString(permissionInfos) +
                ", applicationInfo=" + applicationInfo +
                '}';
    }

    public String[] getPermissionInfos() {
        return permissionInfos;
    }

    public void setPermissionInfos(String[] permissionInfos) {
        this.permissionInfos = permissionInfos;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

}
