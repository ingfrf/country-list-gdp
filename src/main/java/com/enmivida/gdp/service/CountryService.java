package com.enmivida.gdp.service;

import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.model.FindCountryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {
    List<String> findRegions(String continent);

    List<String> findContinents(String region);

    Page<CountryDTO> findCountries(FindCountryParams params, Pageable pageable);
}
