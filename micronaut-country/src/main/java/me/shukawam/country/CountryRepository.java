package me.shukawam.country;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
    
}
