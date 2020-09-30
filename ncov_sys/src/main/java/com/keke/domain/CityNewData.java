package com.keke.domain;

import org.springframework.stereotype.Service;

import java.io.Serializable;

public class CityNewData implements Serializable {

    private String currentConfirmedCount;
    private String confirmedCount;
    private String curedCount;
    private String cityName;
    private String locationId;
    private String deadCount;
    private String suspectedCount;
    private String provinceName;

    public CityNewData(String currentConfirmedCount, String confirmedCount, String curedCount, String cityName, String locationId, String deadCount, String suspectedCount, String provinceName) {
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.curedCount = curedCount;
        this.cityName = cityName;
        this.locationId = locationId;
        this.deadCount = deadCount;
        this.suspectedCount = suspectedCount;
        this.provinceName = provinceName;
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
