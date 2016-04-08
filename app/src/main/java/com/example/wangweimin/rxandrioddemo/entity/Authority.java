package com.example.wangweimin.rxandrioddemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangweimin on 16/4/7.
 */
public class Authority implements Parcelable {
    public String alt;
    public Avatars avatars;
    public String name;
    public String id;

    public Authority() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Authority(Parcel in) {
        alt = in.readString();
        this.avatars = in.readParcelable(Avatars.class.getClassLoader());
        name = in.readString();
        id = in.readString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(alt);
        parcel.writeParcelable(avatars, i);
        parcel.writeString(name);
        parcel.writeString(id);
    }

    public static final Creator<Authority> CREATOR = new Creator<Authority>() {
        @Override
        public Authority createFromParcel(Parcel parcel) {
            return new Authority(parcel);
        }

        @Override
        public Authority[] newArray(int i) {
            return new Authority[i];
        }
    };

    public String toString() {
        return "cast.id=" + id + " cast.name=" + name + "|";
    }
}
