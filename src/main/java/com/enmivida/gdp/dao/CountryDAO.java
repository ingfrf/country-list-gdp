package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CountryDAO {
    List<Country> findAllCountries();
    List<String> findAllRegions();
    List<String> findAllContinents();
    Page<Country> findCountries(Pageable pageable);
}
