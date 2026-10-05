package es.safareyes.parkingapp.dtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class importeTicket {

    private String matricula;
    private Integer minutos;
    private BigDecimal importe;

    public importeTicket(
            String matricula,
            Integer minutos,
            BigDecimal importe) {

        this.matricula = matricula;
        this.minutos = minutos;
        this.importe = importe;
    }
}