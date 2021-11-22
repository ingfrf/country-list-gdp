package com.enmivida.gdp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CountryDTO {
    private String code;
    private String name;
    private String continent;
    private String region;
    private Double surfaceArea;
}
