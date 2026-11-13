package es.safareyes.parkingapp.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class aplicarDescuentoDTO {

    @NotNull(message = "El ID de la promoción es obligatorio")
    @Positive(message = "El ID de la promoción debe ser positivo")
    private Integer idPromocion;
}