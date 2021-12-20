package com.enmivida.gdp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CityDTO {
    private Long id;
    private String name;
    private String countryCode;
    private String district;
    private Long population;
}
