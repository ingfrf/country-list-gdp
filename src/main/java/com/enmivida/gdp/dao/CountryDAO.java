package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.Country;
import com.enmivida.gdp.model.FindCountryParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryDAO {
    List<String> findRegions(String continent);
    List<String> findContinents(String region);
    Page<Country> findCountries(FindCountryParams params, Pageable pageable);
}
