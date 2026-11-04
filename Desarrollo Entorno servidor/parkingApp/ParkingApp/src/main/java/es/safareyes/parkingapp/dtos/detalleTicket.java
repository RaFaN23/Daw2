package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class detalleTicket {

    private Integer id;

    private String matricula;

    private LocalDateTime horaEntrada;

    private LocalDateTime horaSalida;

    private String estado;

    private Integer minutos;

    private Integer numeroPlaza;

    private Integer planta;

    // Tarifa aplicada
    private Integer minCortesia;

    private BigDecimal precioPorMin;

    // Promoción / descuento aplicado
    private String nombrePromocion;

    private String tipoPromocion;

    private BigDecimal descuento;

    private BigDecimal importeDescuento;

    private BigDecimal importe;
}
