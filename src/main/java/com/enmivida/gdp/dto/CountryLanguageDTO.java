package com.enmivida.gdp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CountryLanguageDTO {
    private String countryCode;
    private String language;
    private Boolean isOfficial;
    private Double percentage;
}
