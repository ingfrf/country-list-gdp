package com.enmivida.gdp.utils;

import com.enmivida.gdp.entity.CountryLanguage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryLanguageRowMapper implements RowMapper<CountryLanguage> {
    @Override
    public CountryLanguage mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CountryLanguage.builder()
                .countryCode(rs.getString("CountryCode"))
                .isOfficial(rs.getString("IsOfficial"))
                .percentage(rs.getDouble("Percentage"))
                .language(rs.getString("Language"))
                .build();
    }
}
