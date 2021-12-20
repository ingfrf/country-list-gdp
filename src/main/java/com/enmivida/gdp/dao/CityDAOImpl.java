package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.City;
import com.enmivida.gdp.utils.CityRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringJoiner;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CityDAOImpl implements CityDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<City> findCities(String countryCode) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("code", countryCode);

        StringJoiner query = new StringJoiner(" ");
        query.add("SELECT city.ID, city.Name, city.CountryCode, city.District, city.Population");
        query.add("from world.city");
        query.add("WHERE CountryCode = :code");
        query.add("ORDER BY Population DESC");
        query.add("LIMIT 5");
        return namedParameterJdbcTemplate.query(query.toString(), parameters, new CityRowMapper());
    }
}
