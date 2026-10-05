package es.safareyes.parkingapp.dtos;

import lombok.Data;

@Data
public class tarifasVigentes {

    private Integer idTarifa;
    private String matricula;
    private String nombreUsuario;

    public tarifasVigentes(Integer idTarifa, String matricula, String nombreUsuario) {
        this.idTarifa = idTarifa;
        this.matricula = matricula;
        this.nombreUsuario = nombreUsuario;
    }
}