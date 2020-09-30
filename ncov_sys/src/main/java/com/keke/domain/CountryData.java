package com.keke.domain;

import java.io.Serializable;

public class CountryData implements Serializable {
    private String continents;
    private String provinceName;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String suspectedCount;
    private String curedCount;
    private String deadCount;
    private String deadRate;
    private String countryFullName;

    public CountryData(String continents, String provinceName, String currentConfirmedCount, String confirmedCount, String suspectedCount, String curedCount, String deadCount, String deadRate, String countryFullName) {
        this.continents = continents;
        this.provinceName = provinceName;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.deadRate = deadRate;
        this.countryFullName = countryFullName;
    }

    public String getCountryFullName() {
        return countryFullName;
    }

    public void setCountryFullName(String countryFullName) {
        this.countryFullName = countryFullName;
    }

    public String getContinents() {
        return continents;
    }

    public void setContinents(String continents) {
        this.continents = continents;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(String currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public String getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(String confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public String getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(String suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    public String getDeadRate() {
        return deadRate;
    }

    public void setDeadRate(String deadRate) {
        this.deadRate = deadRate;
    }

    @Override
    public String toString() {
        return "{" +
                "continents:'" + continents + '\'' +
                ", provinceName:'" + provinceName + '\'' +
                ", currentConfirmedCount:'" + currentConfirmedCount + '\'' +
                ", confirmedCount:'" + confirmedCount + '\'' +
                ", suspectedCount:'" + suspectedCount + '\'' +
                ", curedCount:'" + curedCount + '\'' +
                ", deadCount:'" + deadCount + '\'' +
                ", deadRate:'" + deadRate + '\'' +
                ", countryFullName:'" + countryFullName + '\'' +
                '}';
    }
}
