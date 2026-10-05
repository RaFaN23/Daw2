package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class plazasLibres {


    private Integer planta ;

    private String tipo;

    private Long plazasLibres;
}
