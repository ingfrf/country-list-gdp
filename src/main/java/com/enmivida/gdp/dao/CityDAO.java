package com.enmivida.gdp.dao;

import com.enmivida.gdp.entity.City;

import java.util.List;

public interface CityDAO {
    List<City> findCities(String countryCode);
}
