package com.enmivida.gdp.service;

import com.enmivida.gdp.dto.CountryLanguageDTO;

import java.util.List;

public interface CountryLanguageService {
    List<CountryLanguageDTO> findLanguages(String countryCode);
}
