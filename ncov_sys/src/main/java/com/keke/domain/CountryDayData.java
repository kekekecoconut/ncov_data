package com.keke.domain;

import java.io.Serializable;

public class CountryDayData implements Serializable {

    private String date;
    private String confirmed;
    private String cured;
    private String dead;

    @Override
    public String toString() {
        return "CountryDayData{" +
                "date='" + date + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", cured='" + cured + '\'' +
                ", dead='" + dead + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getCured() {
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getDead() {
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }
}
