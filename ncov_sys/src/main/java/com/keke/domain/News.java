package com.keke.domain;

import java.io.Serializable;

public class News implements Serializable {
    private String title;
    private String summary;
    private String infoSource;
    private String sourceUrl;
    private String date;

    public News(String title, String summary, String infoSource, String sourceUrl) {
        this.title = title;
        this.summary = summary;
        this.infoSource = infoSource;
        this.sourceUrl = sourceUrl;
    }

    @Override
    public String toString() {
        return "{" +
                "title:'" + title + '\'' +
                ", summary:'" + summary + '\'' +
                ", infoSource:'" + infoSource + '\'' +
                ", sourceUrl:'" + sourceUrl + '\'' +
                ", date:'" + date + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
