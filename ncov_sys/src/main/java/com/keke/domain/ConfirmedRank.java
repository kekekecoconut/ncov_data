package com.keke.domain;

import java.io.Serializable;

public class ConfirmedRank implements Serializable {
    private String provinceName;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String curedCount;
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public ConfirmedRank(String provinceName, String currentConfirmedCount, String confirmedCount, String curedCount, Integer id) {
        this.provinceName = provinceName;
        this.currentConfirmedCount = currentConfirmedCount;
        this.confirmedCount = confirmedCount;
        this.curedCount = curedCount;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ConfirmedRank{" +
                "provinceName='" + provinceName + '\'' +
                ", currentConfirmedCount='" + currentConfirmedCount + '\'' +
                ", confirmedCount='" + confirmedCount + '\'' +
                ", curedCount='" + curedCount + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
