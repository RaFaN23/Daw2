package es.safareyes.parkingapp.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class tarifasVigentes {

    private Integer idTarifa;
    private Integer minCortesia;
    private BigDecimal precioPorMin;
    private BigDecimal topeMaximo;
    private LocalDate fechaAplica;

    public tarifasVigentes(
            Integer idTarifa,
            Integer minCortesia,
            BigDecimal precioPorMin,
            BigDecimal topeMaximo,
            LocalDate fechaAplica) {

        this.idTarifa = idTarifa;
        this.minCortesia = minCortesia;
        this.precioPorMin = precioPorMin;
        this.topeMaximo = topeMaximo;
        this.fechaAplica = fechaAplica;
    }
}