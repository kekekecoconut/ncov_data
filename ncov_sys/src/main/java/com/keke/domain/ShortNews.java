package com.keke.domain;

import java.io.Serializable;

public class ShortNews implements Serializable {

    private String title;
    private String date;
    private String sourceUrl;

    public ShortNews(String title, String date, String sourceUrl) {
        this.title = title;
        this.date = date;
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        return "{" +
                "title:'" + title + '\'' +
                ", date:'" + date + '\'' +
                ", sourceUrl:'" + sourceUrl + '\'' +
                '}';
    }
}
