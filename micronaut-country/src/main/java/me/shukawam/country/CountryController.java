package me.shukawam.country;

import java.util.List;

import javax.ws.rs.core.MediaType;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import jakarta.inject.Inject;

@Controller("/country")
public class CountryController {
    private final CountryService countryService;

    /**
     * @param countryService
     */
    @Inject
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public List<Country> getAllCountry() {
        return countryService.getAllCountry();
    }

    @Get("/id/{countryId}")
    public Country getCountryById(String countryId) {
        return countryService.getCountryById(countryId);
    }

}
