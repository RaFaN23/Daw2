package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pagoTicketRespuestaDTO {

    private Integer id;
    private String matricula;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private String estado;
    private Integer minutos;
    private BigDecimal descuento;
    private BigDecimal importeDescuento;
    private BigDecimal importe;
    private Integer numeroPlaza;
}