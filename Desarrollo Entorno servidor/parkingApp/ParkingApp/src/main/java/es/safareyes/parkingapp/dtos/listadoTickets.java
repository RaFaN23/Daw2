package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class listadoTickets {

    private Integer id;

    private String matricula;

    private LocalDateTime horaEntrada;

    private LocalDateTime horaSalida;

    private String estado;

    private Integer minutos;

    private BigDecimal importe;

    private Integer numeroPlaza;
}
