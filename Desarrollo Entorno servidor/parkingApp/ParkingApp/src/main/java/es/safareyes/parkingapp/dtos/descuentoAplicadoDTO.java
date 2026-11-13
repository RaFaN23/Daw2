package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class descuentoAplicadoDTO {

    private Integer idTicket;
    private Integer idPromocion;
    private String nombrePromocion;
    private Integer minutosAplicados;
    private Integer totalMinutosDescuento;
    private LocalDateTime fechaAplicacion;
}