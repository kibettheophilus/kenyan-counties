package com.theophiluskibet.kenyancounties.models;

import lombok.Data;

import java.util.List;

@Data
public class County {
    private final String code;
    private final String name;
    private final List<Constituency> constituencies;

    public County(String code, String name, List<Constituency> constituencies) {
        this.code = code;
        this.name = name;
        this.constituencies = constituencies;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Constituency> getConstituencies() {
        return constituencies;
    }
}
