package com.theophiluskibet.kenyancounties.repositories;

import com.theophiluskibet.kenyancounties.entity.CountyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountyRepository extends MongoRepository<CountyEntity, Integer> {
    Optional<CountyEntity> findCountyByCode(String countyCode);

    Optional<CountyEntity> findCountyByName(String countyName);
}
