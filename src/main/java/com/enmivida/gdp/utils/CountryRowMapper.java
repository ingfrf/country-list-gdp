package com.enmivida.gdp.utils;

import com.enmivida.gdp.entity.Country;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CountryRowMapper implements RowMapper<Country> {

    @Override
    public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Country.builder()
                .code(rs.getString("Code"))
                .name(rs.getString("Name"))
                .continent(rs.getString("Continent"))
                .region(rs.getString("Region"))
                .surfaceArea(rs.getDouble("SurfaceArea"))
//                .indepYear(rs.getShort("IndepYear"))
//                .population(rs.getLong("Population"))
//                .lifeExpectancy(rs.getDouble("LifeExpectancy"))
//                .gnp(rs.getDouble("GNP"))
//                .gnpOld(rs.getDouble("GNPOld"))
//                .localName(rs.getString("LocalName"))
//                .govermentForm(rs.getString("GovernmentForm"))
//                .headOfState(rs.getString("HeadOfState"))
//                .code2(rs.getString("Code2"))
                .build();
/*        Long capitalId = rs.getLong("Capital");
        if (capitalId != null) {
            City city = City.builder()
                    .id(capitalId)
                    .name(rs.getString("capital_name"))
                    .build();
            country.setCapital(city);
        }*/
    }
}
