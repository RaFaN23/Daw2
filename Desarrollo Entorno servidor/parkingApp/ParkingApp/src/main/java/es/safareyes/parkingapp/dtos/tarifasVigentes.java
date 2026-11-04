package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class tarifasVigentes {

    private Integer idTarifa;
    private Integer minCortesia;
    private BigDecimal precioPorMin;
    private BigDecimal topeMaximo;
    private LocalDate fechaAplica;


}