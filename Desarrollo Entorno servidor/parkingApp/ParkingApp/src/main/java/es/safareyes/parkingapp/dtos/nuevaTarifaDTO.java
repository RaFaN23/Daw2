package es.safareyes.parkingapp.dtos;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class nuevaTarifaDTO {


    private Integer minCortesia;


    private BigDecimal precioPorMin;


    private BigDecimal topeMaximo;

    private LocalDate fechaAplica;
}
