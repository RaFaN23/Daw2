package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlazaDTO {

    private Integer id;

    private Integer numero;

    private Integer planta;

    private String tipo;

    private String estado;
}
