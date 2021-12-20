package com.enmivida.gdp.utils;

import com.enmivida.gdp.dto.CountryLanguageDTO;
import com.enmivida.gdp.entity.CountryLanguage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper()
public interface CountryLanguageMapper {
    @Mapping(source = "isOfficial", target = "isOfficial", qualifiedByName = "isOfficialBooleanValue")
    CountryLanguageDTO countryLanguageToCountryLanguageDTO(CountryLanguage countryLanguage);

    @Named("isOfficialBooleanValue")
    static boolean isOfficalBooleanValue(String value) {
        return value.equalsIgnoreCase("T") ? true : false;
    }
}
