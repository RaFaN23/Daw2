package es.safareyes.parkingapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class pagarTicketDTO {

    @NotBlank(message = "La matrícula es obligatoria")
    @Pattern(
            regexp = "^[0-9]{4}[A-ZÑ]{3}$",
            message = "La matrícula no tiene un formato válido"
    )
    private String matricula;

    private String codigoCine;
}