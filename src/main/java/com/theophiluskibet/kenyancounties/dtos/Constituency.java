package com.theophiluskibet.kenyancounties.dtos;

import lombok.Data;

import java.util.List;

@Data
public class Constituency {
    private final String name;
    private final List<String> wards;
}
