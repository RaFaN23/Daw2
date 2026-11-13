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
            regexp = "^[0-9]{4}[A-Z]{3}$",
            message = "La matrícula debe tener 4 números y 3 letras"
    )
    private String matricula;

    private String tipoPlaza = "normal";
}