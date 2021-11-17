package com.enmivida.gdp.service;

import com.enmivida.gdp.dao.CountryDAO;
import com.enmivida.gdp.entity.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryDAO countryDAO;

    @Override
    public List<Country> findAllCountries() {
        return countryDAO.findAllCountries();
    }
}
