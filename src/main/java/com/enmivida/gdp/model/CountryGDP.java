package com.enmivida.gdp.model;

import lombok.*;

// no es un modelo de la base de datos,
// es el resultado que se va a enviar a la vista
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CountryGDP {
    private Short year;
    private Double value;
}
