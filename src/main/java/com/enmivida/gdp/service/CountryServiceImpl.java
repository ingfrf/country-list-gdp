package com.enmivida.gdp.service;

import com.enmivida.gdp.dao.CountryDAO;
import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.entity.Country;
import com.enmivida.gdp.utils.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<String> findAllRegions() {
        return countryDAO.findAllRegions();
    }

    @Override
    public List<String> findAllContinents() {
        return countryDAO.findAllContinents();
    }

    @Override
    public Page<CountryDTO> findCountries(Pageable pageable) {
        Page<Country> pageCountry = countryDAO.findCountries(pageable);
        List<CountryDTO> countryList = pageCountry.getContent()
                .stream()
                .map(mapper::countryToCountryDTO)
                .collect(Collectors.toList());
        return new PageImpl<CountryDTO>(countryList, pageable, pageCountry.getTotalElements());
    }
}
