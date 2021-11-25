package com.enmivida.gdp.service;

import com.enmivida.gdp.dto.CountryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findAllCountries();
    List<String> findAllRegions();
    List<String> findAllContinents();
    Page<CountryDTO> findCountries(Pageable pageable);
}
