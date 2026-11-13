package es.safareyes.parkingapp.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class nuevaTarifaDTO {

    @NotNull(message = "Los minutos de cortesía son obligatorios")
    @PositiveOrZero(message = "Los minutos de cortesía no pueden ser negativos")
    private Integer minCortesia;

    @NotNull(message = "El precio por minuto es obligatorio")
    @DecimalMin(value = "0.0", message = "El precio no puede ser negativo")
    private BigDecimal precioPorMin;

    @NotNull(message = "El tope máximo es obligatorio")
    @DecimalMin(value = "0.01", message = "El tope máximo debe ser mayor que cero")
    private BigDecimal topeMaximo;

    @NotNull(message = "La fecha de aplicación es obligatoria")
    private LocalDate fechaAplica;
}