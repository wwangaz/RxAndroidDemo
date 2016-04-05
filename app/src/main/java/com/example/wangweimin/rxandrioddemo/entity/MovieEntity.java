package com.example.wangweimin.rxandrioddemo.entity;

import java.util.List;

/**
 * Created by wangweimin on 16/4/1.
 */
public class MovieEntity {
    public int count;
    public int start;
    public int total;

    public String title;

    public List<Subject> subjects;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("title=" + title + " count=" + count + " start=" + start);
        if (null != subjects) {
            sb.append(" subjects:" + subjects.toString());
        }
        return sb.toString();
    }

    private class Subject {
        public Rating rating;
        public List<String> genres;
        public String title;
        public List<Authority> casts;
        public int collect_count;
        public String original_title;
        public String subtype;
        public List<Authority> directors;
        public String year;
        public Avatars images;
        public String alt;
        public String id;

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

    private class Rating {
        public int max;
        public double average;
        public int min;
        public String stars;
    }

    private class Authority {
        public String alt;
        public Avatars avatars;
        public String name;
        public String id;

        public String toString() {
            return "cast.id=" + id + " cast.name=" + name + "|";
        }
    }

    public class Avatars {
        public String small;
        public String large;
        public String medium;
    }
}
