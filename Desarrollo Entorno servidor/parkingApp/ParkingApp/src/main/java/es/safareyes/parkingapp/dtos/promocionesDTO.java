package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class promocionesDTO {
    private Integer id;
    private String nombre;
    private String tipo;
    private Integer minDescuento;   
}