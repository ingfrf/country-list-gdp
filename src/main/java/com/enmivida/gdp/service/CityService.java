package com.enmivida.gdp.service;

import com.enmivida.gdp.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> findCities(String codeCountry);
}
