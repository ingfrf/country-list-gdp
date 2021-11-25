package com.enmivida.gdp.controller;

import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gdp/api")
@RequiredArgsConstructor
public class GDPController {

    private final CountryService countryService;

    @Value("${country.page.size}")
    private Integer pageSize;

    @GetMapping("/countries")
    public ResponseEntity<Page<CountryDTO>> findCountries(@RequestParam Integer page) {
        // TODO sort field
        //PageRequest pageable = PageRequest.of(0, 5, Sort.Direction.fromString("DESC"), "USERNAME");
        PageRequest pageable = PageRequest.of(page, pageSize, Sort.Direction.fromString("ASC"), "CODE");

        Page<CountryDTO> pagedCountries = countryService.findCountries(pageable);

        return new ResponseEntity<Page<CountryDTO>>(pagedCountries, HttpStatus.OK);
    }

    @GetMapping("/regions")
    public ResponseEntity<List<String>> findAllRegions() {
        return new ResponseEntity<>(countryService.findAllRegions(),HttpStatus.OK);
    }

    @GetMapping("/continents")
    public ResponseEntity<List<String>> findAllContinents() {
        return new ResponseEntity<>(countryService.findAllContinents(), HttpStatus.OK);
    }

}
