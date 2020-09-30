package com.keke.domain;

import java.io.Serializable;

public class EveryCountryData implements Serializable {

    private String date;
    private String confirmed;
    private String country;


    @Override
    public String toString() {
        return "EveryCountryData{" +
                "date='" + date + '\'' +
                ", confirmed='" + confirmed + '\'' +
                ", country='" + country + '\'' +
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
