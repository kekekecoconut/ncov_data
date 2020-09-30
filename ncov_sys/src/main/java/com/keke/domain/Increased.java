package com.keke.domain;

import java.io.Serializable;
import java.util.List;

public class Increased implements Serializable {
    private String country;
    private List<String> date;
    private List<Integer> increased;

    @Override
    public String toString() {
        return "Increased{" +
                "country='" + country + '\'' +
                ", date=" + date +
                ", increased=" + increased +
                '}';
    }

    public Increased(String country, List<String> date, List<Integer> increased) {
        this.country = country;
        this.date = date;
        this.increased = increased;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getDate() {
        return date;
    }

    public void setDate(List<String> date) {
        this.date = date;
    }

    public List<Integer> getIncreased() {
        return increased;
    }

    public void setIncreased(List<Integer> increased) {
        this.increased = increased;
    }
}
