package com.enmivida.gdp.service;

import com.enmivida.gdp.dao.CountryDAO;
import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.utils.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryDAO countryDAO;
    private final CountryMapper mapper;

    @Override
    public List<CountryDTO> findAllCountries() {
        return countryDAO.findAllCountries().stream().map(mapper::countryToCountryDTO).collect(Collectors.toList());
    }
}
