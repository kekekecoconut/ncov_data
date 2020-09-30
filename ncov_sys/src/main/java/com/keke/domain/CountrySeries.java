package com.keke.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class CountrySeries implements Serializable {

    private String name;
    private String type;
    private String stack;
    private ArrayList<String> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", type:'" + type + '\'' +
                ", stack:'" + stack + '\'' +
                ", data:" + data +
                '}';
    }
}
