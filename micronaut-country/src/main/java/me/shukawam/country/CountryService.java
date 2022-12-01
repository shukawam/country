package me.shukawam.country;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.NotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class CountryService {
    private final CountryRepository countryRepository;
    private static final Logger logger = LoggerFactory.getLogger(CountryService.class);

    /**
     * @param countryRepository
     */
    @Inject
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountry() {
        logger.debug("Inside CountryService#getAllCountry");
        List<Country> countryList = new ArrayList<>();
        countryRepository.findAll().iterator().forEachRemaining(countryList::add);
        return countryList;
    }

    public Country getCountryById(String countryId) {
        logger.debug("Inside CountryService#getCountryById");
        var optionalCountry = countryRepository.findById(countryId);
        if (optionalCountry.isEmpty()) {
            logger.info("country: %s is not found.", countryId);
            throw new NotFoundException(String.format("country: %s is not found.", countryId));
        } else {
            return optionalCountry.get();
        }
    }

}
