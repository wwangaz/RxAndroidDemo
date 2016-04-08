package com.example.wangweimin.rxandrioddemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by wangweimin on 16/4/7.
 */
public class Avatars implements Parcelable {
    public String small;
    public String large;
    public String medium;

    public Avatars() {
    }

    public Avatars(Parcel in) {
        small = in.readString();
        large = in.readString();
        medium = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(small);
        parcel.writeString(large);
        parcel.writeString(medium);
    }

    static final Creator<Avatars> CREATOR = new Creator<Avatars>() {
        @Override
        public Avatars createFromParcel(Parcel parcel) {
            return new Avatars(parcel);
        }

        @Override
        public Avatars[] newArray(int i) {
            return new Avatars[i];
        }
    };
}
