package com.keke.domain;

import java.io.Serializable;

public class ProvinceData implements Serializable {

    private String provinceName;
    private String provinceShortName;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String suspectedCount;
    private String curedCount;
    private String deadCount;
    private String comment;
    private String locationId;

    public ProvinceData(String provinceName, String provinceShortName, String currentConfirmedCount, String confirmedCount, String suspectedCount, String curedCount, String deadCount, String comment, String locationId) {
        this.provinceName = provinceName;
        this.provinceShortName = provinceShortName;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.suspectedCount = suspectedCount;
        this.curedCount = curedCount;
        this.deadCount = deadCount;
        this.comment = comment;
        this.locationId = locationId;
    }



    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceShortName() {
        return provinceShortName;
    }

    public void setProvinceShortName(String provinceShortName) {
        this.provinceShortName = provinceShortName;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "{" +
                "provinceName:'" + provinceName + '\'' +
                ", provinceShortName:'" + provinceShortName + '\'' +
                ", currentConfirmedCount:'" + currentConfirmedCount + '\'' +
                ", confirmedCount:'" + confirmedCount + '\'' +
                ", suspectedCount:'" + suspectedCount + '\'' +
                ", curedCount:'" + curedCount + '\'' +
                ", deadCount:'" + deadCount + '\'' +
                ", comment:'" + comment + '\'' +
                ", locationId:'" + locationId + '\'' +
                '}';
    }
}
