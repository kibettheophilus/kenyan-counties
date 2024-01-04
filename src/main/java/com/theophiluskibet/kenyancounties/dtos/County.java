package com.theophiluskibet.kenyancounties.dtos;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
@Data
public class County {
    private final String code;
    private final String name;
    private final List<Constituency> constituencies;
}
