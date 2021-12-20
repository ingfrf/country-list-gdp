package com.enmivida.gdp.utils;

import com.enmivida.gdp.dto.CityDTO;
import com.enmivida.gdp.entity.City;
import org.mapstruct.Mapper;

@Mapper()
public interface CityMapper {
    CityDTO cityToCityDTO(City city);
}
