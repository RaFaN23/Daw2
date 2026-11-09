package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class altaPlazaDTO {

    private Integer numero;
    private Integer planta;
    private String tipo;
    private String estado;
}