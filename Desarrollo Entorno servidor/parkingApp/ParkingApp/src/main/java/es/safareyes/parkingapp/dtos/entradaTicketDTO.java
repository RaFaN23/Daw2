package es.safareyes.parkingapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class entradaTicketDTO {

    @NotBlank(message = "La matrícula es obligatoria")
    @Pattern(
            regexp = "(?i)^[0-9]{4}[A-ZÑ]{3}$",
            message = "La matrícula debe tener 4 números y 3 letras"
    )
    private String matricula;

    @Pattern(
            regexp = "(?i)^(normal|movilidad reducida|cargador electrico)$",
            message = "El tipo de plaza no es válido"
    )
    private String tipoPlaza = "normal";
}