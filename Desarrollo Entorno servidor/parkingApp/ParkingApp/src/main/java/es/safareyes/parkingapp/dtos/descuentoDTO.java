package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class descuentoDTO {

    private String nombrePromocion;

    private String tipoPromocion;

    private Integer minutosAplicados;
}