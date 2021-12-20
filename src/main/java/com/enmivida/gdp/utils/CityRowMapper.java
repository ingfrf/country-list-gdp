package com.enmivida.gdp.utils;

import com.enmivida.gdp.entity.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CityRowMapper implements RowMapper<City> {

    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        return City.builder()
                .id(rs.getLong("ID"))
                .name(rs.getString("Name"))
                .countryCode(rs.getString("CountryCode"))
                .district(rs.getString("District"))
                .population(rs.getLong("Population"))
                .build();
    }
}
