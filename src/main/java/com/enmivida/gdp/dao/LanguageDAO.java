package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.CountryLanguage;

import java.util.List;

public interface LanguageDAO {
    List<CountryLanguage> findLanguages(String codeCountry);
}
