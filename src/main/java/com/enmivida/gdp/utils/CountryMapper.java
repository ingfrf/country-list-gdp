package com.enmivida.gdp.utils;

import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.entity.Country;
import org.mapstruct.Mapper;

@Mapper()
public interface CountryMapper {
    CountryDTO countryToCountryDTO(Country country);
}
