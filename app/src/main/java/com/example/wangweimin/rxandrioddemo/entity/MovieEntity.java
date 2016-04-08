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
}
