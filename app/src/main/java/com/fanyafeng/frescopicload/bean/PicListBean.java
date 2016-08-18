package com.fanyafeng.frescopicload.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author： fanyafeng
 * Data： 16/8/16 17:35
 * Email: fanyafeng@live.cn
 */
public class PicListBean implements Parcelable {
    private String picUrl;

    public PicListBean() {
    }

    protected PicListBean(Parcel in) {
        picUrl = in.readString();
    }

    public static final Creator<PicListBean> CREATOR = new Creator<PicListBean>() {
        @Override
        public PicListBean createFromParcel(Parcel in) {
            return new PicListBean(in);
        }

        @Override
        public PicListBean[] newArray(int size) {
            return new PicListBean[size];
        }
    };

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @Override
    public String toString() {
        return "PicListBean{" +
                "picUrl='" + picUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(picUrl);
    }
}
