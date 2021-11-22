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
        query.add("SELECT `country`.`Code`,\n" +
                "    `country`.`Name`,\n" +
                "    `country`.`Continent`,\n" +
                "    `country`.`Region`,\n" +
                "    `country`.`SurfaceArea`,\n" +
                "    `country`.`IndepYear`,\n" +
                "    `country`.`Population`,\n" +
                "    `country`.`LifeExpectancy`,\n" +
                "    `country`.`GNP`,\n" +
                "    `country`.`GNPOld`,\n" +
                "    `country`.`LocalName`,\n" +
                "    `country`.`GovernmentForm`,\n" +
                "    `country`.`HeadOfState`,\n" +
                "    `country`.`Capital`,\n" +
                "    `country`.`Code2`\n");
        query.add("from world.country");
        return jdbcTemplate.query(query.toString(), new CountryRowMapper());
    }
}
