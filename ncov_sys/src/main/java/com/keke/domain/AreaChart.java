package com.keke.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class AreaChart implements Serializable {
    private String name;
    private List<Integer> data;

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", data:" + data +
                '}';
    }

    public AreaChart(String name,List<Integer> data) {
        this.name = name;
        this.data = data;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(LinkedList<Integer> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
