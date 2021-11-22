package com.enmivida.gdp.utils;

import com.enmivida.gdp.dto.CountryDTO;
import com.enmivida.gdp.entity.Country;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

// ignora los campos que faltan
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper {
    CountryDTO countryToCountryDTO(Country country);
}
