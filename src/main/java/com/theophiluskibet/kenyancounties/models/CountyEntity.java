package com.theophiluskibet.kenyancounties.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("county")
public class CountyEntity {
    private final String  code;
    private final String name;
    private final List<Constituency> constituencies;

    public CountyEntity(String code, String name, List<Constituency> constituencies) {
        this.code = code;
        this.name = name;
        this.constituencies = constituencies;
    }
}
