package com.example.wangweimin.rxandrioddemo.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangweimin on 16/4/7.
 */
public class Subject implements Parcelable {
    public String id;
    public String title;
    public String original_title;
    public List<String> genres;
    public List<Authority> casts;
    public List<Authority> directors;
    public String year;
    public Avatars images;
    public String summary;
    //    public Rating rating;
    //    public int collect_count;
    //    public String alt;
    //    public String subtype;

    public Subject(Parcel in) {
        id = in.readString();
        title = in.readString();
        original_title = in.readString();
        genres = new ArrayList<>();
        in.readStringList(genres);
        casts = new ArrayList<>();
        in.readTypedList(casts, Authority.CREATOR);
        directors = new ArrayList<>();
        in.readTypedList(directors, Authority.CREATOR);
        year = in.readString();
        images = in.readParcelable(Avatars.class.getClassLoader());
        summary = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(original_title);
        parcel.writeStringList(genres);
        parcel.writeList(casts);
        parcel.writeList(directors);
        parcel.writeString(year);
        parcel.writeParcelable(images, i);
        parcel.writeString(summary);
    }

    public static final Creator<Subject> CREATOR = new Creator<Subject>() {
        @Override
        public Subject createFromParcel(Parcel parcel) {
            return new Subject(parcel);
        }

        @Override
        public Subject[] newArray(int i) {
            return new Subject[i];
        }
    };

    public String toString() {
        return "Subject.id=" + id
                + " Subject.title=" + title
                + " Subject.year=" + year
                + " Subject.originalTitle=" + original_title
                + casts.toString()
                + directors.toString()
                + "|";
    }
}
