package com.enmivida.gdp.service;

import com.enmivida.gdp.dao.LanguageDAO;
import com.enmivida.gdp.dto.CountryLanguageDTO;
import com.enmivida.gdp.utils.CountryLanguageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryLanguageServiceImpl implements CountryLanguageService {

    private final LanguageDAO languageDAO;
    private final CountryLanguageMapper mapper;

    @Override
    public List<CountryLanguageDTO> findLanguages(String countryCode) {
        return languageDAO.findLanguages(countryCode)
                .stream()
                .map(mapper::countryLanguageToCountryLanguageDTO)
                .collect(Collectors.toList());
    }
}
