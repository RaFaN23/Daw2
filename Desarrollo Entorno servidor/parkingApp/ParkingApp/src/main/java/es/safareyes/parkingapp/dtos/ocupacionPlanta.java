package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ocupacionPlanta {

    private Integer planta;

    private Long totalPlazas;

    private Long plazasOcupadas;

    private BigDecimal porcentajeOcupacion;

    // media de minutos de los tickets cerrados de esa planta
    private BigDecimal estanciaMedia;
}
