package com.theophiluskibet.kenyancounties.models;

import java.util.List;

public class Constituency {
    private final String name;
    private final List<String> wards;

    public Constituency(String name, List<String> wards) {
        this.name = name;
        this.wards = wards;
    }

    public String getName() {
        return name;
    }

    public List<String> getWards() {
        return wards;
    }
}
