package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.Country;
import com.enmivida.gdp.utils.CountryRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<String> findAllRegions() {
        StringJoiner query = new StringJoiner(" ");
        query.add("select distinct (Region)");
        query.add("from world.country");
        return jdbcTemplate.queryForList(query.toString(), String.class);
    }

    @Override
    public List<String> findAllContinents() {
        StringJoiner query = new StringJoiner(" ");
        query.add("select distinct (Continent)");
        query.add("from world.country");
        return jdbcTemplate.queryForList(query.toString(), String.class);
    }

    @Override
    public Page<Country> findCountries(Pageable pageable) {
        Sort.Order order = !pageable.getSort().isEmpty() ? pageable.getSort().toList().get(0): Sort.Order.by("Code");

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
        query.add("ORDER BY").add(order.getProperty()).add(order.getDirection().name());
        query.add("LIMIT").add(Integer.toString(pageable.getPageSize()));
        query.add("OFFSET").add(Long.toString(pageable.getOffset()));

        List<Country> countryList = jdbcTemplate.query(query.toString(), new CountryRowMapper());
        return new PageImpl<Country>(countryList, pageable, countryCount());
    }

    private int countryCount() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM world.country", Integer.class);
    }
}
