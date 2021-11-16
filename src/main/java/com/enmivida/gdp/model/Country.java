package com.enmivida.gdp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Country {
    @NotNull
    @Size(max = 3, min = 3)
    private String code;
    @NotNull
    @Size(max = 52)
    private String name;
    @NotNull
    private String continent;
    @NotNull
    @Size(max = 26)
    private String region;
    @NotNull
    private Double surfaceArea;
    private Short indepYear;
    @NotNull
    private Long population;
    private Double lifeExpectancy;
    private Double gnp;
    private Double gnpOld;
    @NotNull
    @Size(max = 45)
    private String localName;
    @NotNull
    @Size(max = 45)
    private String govermentForm;
    private String headOfState;
    private Integer capital;
    @NotNull
    @Size(max = 2, min = 2)
    private String code2;
}

/*CREATE TABLE `country` (
  `Code` char(3) NOT NULL DEFAULT '',
  `Name` char(52) NOT NULL DEFAULT '',
  `Continent` enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America') NOT NULL DEFAULT 'Asia',
  `Region` char(26) NOT NULL DEFAULT '',
  `SurfaceArea` decimal(10,2) NOT NULL DEFAULT '0.00',
  `IndepYear` smallint DEFAULT NULL,
  `Population` int NOT NULL DEFAULT '0',
  `LifeExpectancy` decimal(3,1) DEFAULT NULL,
  `GNP` decimal(10,2) DEFAULT NULL,
  `GNPOld` decimal(10,2) DEFAULT NULL,
  `LocalName` char(45) NOT NULL DEFAULT '',
  `GovernmentForm` char(45) NOT NULL DEFAULT '',
  `HeadOfState` char(60) DEFAULT NULL,
  `Capital` int DEFAULT NULL,
  `Code2` char(2) NOT NULL DEFAULT '',
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci*/
