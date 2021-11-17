package com.enmivida.gdp.controller;

import com.enmivida.gdp.entity.Country;
import com.enmivida.gdp.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gdp/api")
@RequiredArgsConstructor
public class GDPController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public List<Country> findAllCountries() {
        return countryService.findAllCountries();
    }

}
