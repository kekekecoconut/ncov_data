package com.keke.domain;

import java.io.Serializable;

public class CityData implements Serializable {

    private String currentConfirmedCount;
    private String confirmedCount;
    private String curedCount;
    private String cityName;
    private String locationId;
    private String deadCount;
    private String suspectedCount;


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

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    public String getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(String suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    @Override
    public String toString() {
        return "{" +
                "currentConfirmedCount:'" + currentConfirmedCount + '\'' +
                ", confirmedCount:'" + confirmedCount + '\'' +
                ", curedCount:'" + curedCount + '\'' +
                ", cityName:'" + cityName + '\'' +
                ", locationId:'" + locationId + '\'' +
                ", deadCount:'" + deadCount + '\'' +
                ", suspectedCount:'" + suspectedCount + '\'' +
                '}';
    }
}
