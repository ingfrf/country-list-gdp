package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.Country;

import java.util.List;

public interface CountryDAO {
    List<Country> findAllCountries();
}
