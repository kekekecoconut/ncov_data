package com.keke.domain;

import java.io.Serializable;

public class CountryConfirmed implements Serializable {

    private String name;
    private Integer value;

    public CountryConfirmed(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "name:\"" + name + '"' +
                ", value:" + value +
                '}';
    }
}
