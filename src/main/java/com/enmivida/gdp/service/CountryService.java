package com.enmivida.gdp.service;

import com.enmivida.gdp.dto.CountryDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findAllCountries();
}
