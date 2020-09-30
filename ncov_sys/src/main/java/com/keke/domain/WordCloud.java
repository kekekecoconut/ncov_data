package com.keke.domain;

import java.io.Serializable;
import java.util.Objects;

public class WordCloud implements Serializable {
    private Integer value;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordCloud wordCloud = (WordCloud) o;
        return Objects.equals(name, wordCloud.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public WordCloud(Integer value, String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
