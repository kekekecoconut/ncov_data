package com.keke.domain;

import java.io.Serializable;

public class CountryShortData implements Serializable {
    private String country;
    private Double deadrate;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getDeadrate() {
        return deadrate;
    }

    public void setDeadrate(Double deadrate) {
        this.deadrate = deadrate;
    }

    @Override
    public String toString() {
        return "CountryShortData{" +
                "country='" + country + '\'' +
                ", deadrate=" + deadrate +
                '}';
    }

    public CountryShortData(String country, Double deadrate) {
        this.country = country;
        this.deadrate = deadrate;
    }
}
