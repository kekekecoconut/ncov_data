package com.keke.domain;

import java.io.Serializable;

public class WorldData implements Serializable {
    private String date;
    private String country;
    private String countryCode;
    private String province;
    private String city;
    private String provinceCode;
    private String cityCode;
    private String suspected;
    private String cured;
    private String dead;
    private String confirmed;

    public WorldData(String date, String country, String countryCode, String province, String city, String provinceCode, String cityCode, String suspected, String cured, String dead, String confirmed) {
        this.date = date;
        this.country = country;
        this.countryCode = countryCode;
        this.province = province;
        this.city = city;
        this.provinceCode = provinceCode;
        this.cityCode = cityCode;
        this.suspected = suspected;
        this.cured = cured;
        this.dead = dead;
        this.confirmed = confirmed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getSuspected() {
        return suspected;
    }

    public void setSuspected(String suspected) {
        this.suspected = suspected;
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

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "WorldData{" +
                "date='" + date + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", suspected='" + suspected + '\'' +
                ", cured='" + cured + '\'' +
                ", dead='" + dead + '\'' +
                ", confirmed='" + confirmed + '\'' +
                '}';
    }
}
