package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.Country;
import com.enmivida.gdp.model.FindCountryParams;
import com.enmivida.gdp.utils.CountryRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.StringJoiner;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CountryDAOImpl implements CountryDAO {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<String> findRegions(String continent) {
        StringJoiner query = new StringJoiner(" ");
        query.add("select distinct (Region)");
        query.add("from world.country");
        if (continent != null && !continent.equalsIgnoreCase("All")) {
            query.add("where Continent=?");
            return jdbcTemplate.queryForList(query.toString(), String.class, continent);
        }
        log.warn("findRegions");
        return jdbcTemplate.queryForList(query.toString(), String.class);
    }

    @Override
    public List<String> findContinents(String region) {
        StringJoiner query = new StringJoiner(" ");
        query.add("select distinct (Continent)");
        query.add("from world.country");
        if (region != null && !region.equalsIgnoreCase("All")) {
            query.add("where Region=?");
            return jdbcTemplate.queryForList(query.toString(), String.class, region);
        }
        log.warn("findContinents");
        return jdbcTemplate.queryForList(query.toString(), String.class);
    }

    @Override
    public Page<Country> findCountries(FindCountryParams params, Pageable pageable) {
        Sort.Order order = !pageable.getSort().isEmpty() ? pageable.getSort().toList().get(0) : Sort.Order.by("Code");

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        StringJoiner conditions = new StringJoiner(" ");
        conditions.add("WHERE 1");
        if (params.getName() != null) {
            conditions.add("AND").add("Name").add("like").add(":name");
            parameters.addValue("name", "%" + params.getName() + "%");
        }
        if (params.getContinent() != null && !params.getContinent().equalsIgnoreCase("All")) {
            conditions.add("AND").add("Continent").add("like").add(":continent");
            parameters.addValue("continent", params.getContinent());
        }
        if (params.getRegion() != null && !params.getRegion().equalsIgnoreCase("All")) {
            conditions.add("AND").add("Region").add("like").add(":region");
            parameters.addValue("region", params.getRegion());
        }

        // count
        StringJoiner count = new StringJoiner(" ");
        count.add("SELECT count(*) FROM world.country");
        count.add(conditions.toString());
        int total = namedParameterJdbcTemplate.queryForObject(count.toString(), parameters, Integer.class);

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
        query.add(conditions.toString());
        query.add("ORDER BY").add(order.getProperty()).add(order.getDirection().name());
        query.add("LIMIT").add(Integer.toString(pageable.getPageSize()));
        query.add("OFFSET").add(Long.toString(pageable.getOffset()));

        List<Country> countryList = namedParameterJdbcTemplate.query(query.toString(), parameters, new CountryRowMapper());
        log.warn("findCountries");
        return new PageImpl<Country>(countryList, pageable, total);
    }

}
