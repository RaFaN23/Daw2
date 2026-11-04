package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class importeTicket {

    private String matricula;
    private Integer minutos;
    private BigDecimal importe;


}