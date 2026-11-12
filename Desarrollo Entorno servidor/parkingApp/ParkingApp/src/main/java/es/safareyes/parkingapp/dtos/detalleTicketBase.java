package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class detalleTicketBase {

    private Integer id;
    private String matricula;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private String estado;
    private Integer minutos;
    private Integer numeroPlaza;
    private Integer planta;
    private Integer minCortesia;
    private BigDecimal precioPorMin;
    private BigDecimal descuento;
    private BigDecimal importeDescuento;
    private BigDecimal importe;
}