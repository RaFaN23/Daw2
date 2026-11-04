package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class recaudacionDia {

    private LocalDate dia;

    private Long numTickets;

    private BigDecimal recaudacion;
}
