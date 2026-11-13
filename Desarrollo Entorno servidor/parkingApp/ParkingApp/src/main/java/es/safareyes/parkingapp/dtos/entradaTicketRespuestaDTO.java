package es.safareyes.parkingapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class entradaTicketRespuestaDTO {

    private Integer id;
    private String matricula;
    private LocalDateTime horaEntrada;
    private String estado;
    private Integer numeroPlaza;
    private Integer planta;
    private String tipoPlaza;
    private Integer idTarifa;
}