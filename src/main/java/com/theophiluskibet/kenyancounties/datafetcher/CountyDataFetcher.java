package com.theophiluskibet.kenyancounties.datafetcher;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.theophiluskibet.graphql.types.County;
import com.theophiluskibet.graphql.types.CountyInput;
import com.theophiluskibet.graphql.types.CountyResponse;
import com.theophiluskibet.kenyancounties.models.Constituency;
import com.theophiluskibet.kenyancounties.models.CountyEntity;
import com.theophiluskibet.kenyancounties.repositories.CountyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@DgsComponent
public class CountyDataFetcher {
    private final CountyRepository countyRepository;

    public CountyDataFetcher(CountyRepository countyRepository) {
        this.countyRepository = countyRepository;
    }

    @DgsQuery
    public CountyResponse getCounties(@InputArgument String name) {

        if (name == null) {
            return new CountyResponse(
                    true,
                    "Counties fetched",
                    countyResponseMapper(countyRepository.findAll())
            );
        }

        return new CountyResponse(
                true,
                "County fetched",
                countyResponseMapper(countyRepository.findAll().stream().filter(county -> county.getName().contains(name)).collect(Collectors.toList())));
    }

    @DgsMutation
    public CountyResponse addCounty(@InputArgument CountyInput county) {
        Optional<CountyEntity> countyEntityByCode = countyRepository.findCountyByCode(county.getCode());
        Optional<CountyEntity> countyEntityByName = countyRepository.findCountyByName(county.getName());
        if (countyEntityByCode.isPresent() || countyEntityByName.isPresent()) {
            return new CountyResponse(false, "County already exists", null);
        } else {
            countyRepository.save(countyInputMapper(county));
            return new CountyResponse(true, "County added successfully", null);
        }
    }

    private CountyEntity countyInputMapper(CountyInput input) {
        return new CountyEntity(input.getCode(),
                input.getName(),
                input.getConstituencies().stream().map(cons -> new Constituency(cons.getName(), cons.getWards())).collect(Collectors.toList()));
    }

    private List<com.theophiluskibet.graphql.types.County> countyResponseMapper(List<CountyEntity> countyEntity) {
        return countyEntity.stream().map(entity -> new County(entity.getCode(), entity.getName(), entity.getConstituencies().stream().map(c -> new com.theophiluskibet.graphql.types.Constituency(c.getName(), c.getWards())).collect(Collectors.toList()))).collect(Collectors.toList());
    }
}
