package com.enmivida.gdp.service;

import com.enmivida.gdp.dao.CountryDAO;
import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.entity.Country;
import com.enmivida.gdp.model.FindCountryParams;
import com.enmivida.gdp.utils.CountryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryDAO countryDAO;
    private final CountryMapper mapper;

    @Override
    public List<String> findRegions(String continent) {
        return countryDAO.findRegions(continent);
    }

    @Override
    public List<String> findContinents(String region) {
        return countryDAO.findContinents(region);
    }

    @Override
    public Page<CountryDTO> findCountries(FindCountryParams params, Pageable pageable) {
        Page<Country> pageCountry = countryDAO.findCountries(params, pageable);
        List<CountryDTO> countryList = pageCountry.getContent()
                .stream()
                .map(mapper::countryToCountryDTO)
                .collect(Collectors.toList());
        return new PageImpl<CountryDTO>(countryList, pageable, pageCountry.getTotalElements());
    }
}
