package es.safareyes.parkingapp.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class altaPlazaDTO {

    @NotNull(message = "El número de plaza es obligatorio")
    @Positive(message = "El número debe ser positivo")
    private Integer numero;

    @NotNull(message = "La planta es obligatoria")
    @Min(value = -3, message = "La planta mínima es -3")
    @Max(value = -1, message = "La planta máxima es -1")
    private Integer planta;

    @NotBlank(message = "El tipo de plaza es obligatorio")
    @Pattern(
            regexp = "(?i)^(normal|movilidad reducida|cargador electrico)$",
            message = "El tipo de plaza no es válido"
    )
    private String tipo;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(
            regexp = "(?i)^(libre|bloqueada)$",
            message = "El estado debe ser libre o bloqueada"
    )
    private String estado;
}