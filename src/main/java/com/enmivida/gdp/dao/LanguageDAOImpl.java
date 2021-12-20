package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.CountryLanguage;
import com.enmivida.gdp.utils.CountryLanguageRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringJoiner;

@Repository
@RequiredArgsConstructor
public class LanguageDAOImpl implements LanguageDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<CountryLanguage> findLanguages(String countryCode) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("code", countryCode);

        StringJoiner query = new StringJoiner(" ");
        query.add("SELECT countrylanguage.CountryCode, countrylanguage.Language, countrylanguage.IsOfficial, countrylanguage.Percentage");
        query.add("FROM world.countrylanguage");
        query.add("WHERE CountryCode=:code");
        query.add("ORDER BY Percentage DESC");
        return namedParameterJdbcTemplate.query(query.toString(), parameters, new CountryLanguageRowMapper());
    }
}
