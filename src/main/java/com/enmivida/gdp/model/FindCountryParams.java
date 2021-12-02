package com.enmivida.gdp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FindCountryParams implements Serializable {
    private static final long serialVersionUID = -549419605587967613L;

    private Integer page;
    private String name;
    private String continent;
    private String region;
}
