package com.enmivida.gdp.service;

import com.enmivida.gdp.dao.CityDAO;
import com.enmivida.gdp.dto.CityDTO;
import com.enmivida.gdp.utils.CityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityDAO cityDAO;
    private final CityMapper mapper;

    @Override
    public List<CityDTO> findCities(String codeCountry) {
        return cityDAO.findCities(codeCountry)
                .stream()
                .map(mapper::cityToCityDTO)
                .collect(Collectors.toList());
    }
}
