package es.safareyes.parkingapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class cambiarEstadoPlazaDTO {

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(
            regexp = "(?i)^(libre|bloqueada)$",
            message = "El estado debe ser libre o bloqueada"
    )
    private String estado;
}