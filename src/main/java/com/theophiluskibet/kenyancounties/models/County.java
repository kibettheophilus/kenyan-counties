package com.theophiluskibet.kenyancounties.models;

import java.util.List;

public class County {
    private final Integer code;
    private final String name;
    private final List<Constituency> constituencies;

    public County(Integer code, String name, List<Constituency> constituencies) {
        this.code = code;
        this.name = name;
        this.constituencies = constituencies;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Constituency> getConstituencies() {
        return constituencies;
    }
}
