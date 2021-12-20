package com.enmivida.gdp.controller;

import com.enmivida.gdp.dto.CityDTO;
import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.dto.CountryLanguageDTO;
import com.enmivida.gdp.model.FindCountryParams;
import com.enmivida.gdp.service.CityService;
import com.enmivida.gdp.service.CountryLanguageService;
import com.enmivida.gdp.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gdp/api")
@RequiredArgsConstructor
public class GDPController {

    private final CountryService countryService;
    private final CityService cityService;
    private final CountryLanguageService countryLanguageService;

    @Value("${country.page.size}")
    private Integer pageSize;

    @PostMapping("/countries")
    public ResponseEntity<Page<CountryDTO>> findCountries(@RequestBody FindCountryParams findCountryParams) {
        // TODO sort field
        //PageRequest pageable = PageRequest.of(0, 5, Sort.Direction.fromString("DESC"), "USERNAME");
        PageRequest pageable = PageRequest.of(findCountryParams.getPage(), pageSize, Sort.Direction.fromString("ASC"), "CODE");

        Page<CountryDTO> pagedCountries = countryService.findCountries(findCountryParams, pageable);

        return new ResponseEntity<Page<CountryDTO>>(pagedCountries, HttpStatus.OK);
    }

    @GetMapping("/regions")
    public ResponseEntity<List<String>> findRegions(@RequestParam String continent) {
        return new ResponseEntity<>(countryService.findRegions(continent), HttpStatus.OK);
    }

    @GetMapping("/continents")
    public ResponseEntity<List<String>> findAllContinents(@RequestParam String region) {
        return new ResponseEntity<>(countryService.findContinents(region), HttpStatus.OK);
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityDTO>> findAllCitiesByCountry(@RequestParam String code) {
        return new ResponseEntity<>(cityService.findCities(code), HttpStatus.OK);
    }

    @GetMapping("/languages")
    public ResponseEntity<List<CountryLanguageDTO>> findAllLanguagesByCountry(@RequestParam String code) {
        return new ResponseEntity<>(countryLanguageService.findLanguages(code), HttpStatus.OK);
    }

}
