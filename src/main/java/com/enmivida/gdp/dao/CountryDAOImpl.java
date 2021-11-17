package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.Country;
import com.enmivida.gdp.utils.CountryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringJoiner;

@Repository
@RequiredArgsConstructor
public class CountryDAOImpl implements CountryDAO {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Country> findAllCountries() {
        StringJoiner query = new StringJoiner(" ");
        query.add("select Code, Name, Continent, Region, SurfaceArea");
        query.add("from world.country");
        return jdbcTemplate.query(query.toString(), new CountryRowMapper());
    }
}
