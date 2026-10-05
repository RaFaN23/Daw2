package es.safareyes.parkingapp;
import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.Modelos.Tarifa;
import es.safareyes.parkingapp.Repositorio.PlazaRepositorio;
import es.safareyes.parkingapp.Repositorio.TarifaRepositorio;
import es.safareyes.parkingapp.Repositorio.TicketsRepositorio;
import es.safareyes.parkingapp.dtos.importeTicket;
import es.safareyes.parkingapp.dtos.plazasLibres;
import es.safareyes.parkingapp.dtos.tarifasVigentes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class pruebas {

    @Autowired
    private PlazaRepositorio plazaRepositorio;
    @Test
    void buscarPlaza(){
        List<Plaza> plazas = plazaRepositorio.buscarPlazas();
        System.out.println("plazas encontrados: " + plazas.size());

        for (Plaza plaza : plazas) {
            System.out.println(
                    "Planta: " + plaza.getPlanta() +
                            " | Tipo: " + plaza.getTipo() +
                            " | Estado: " + plaza.getEstado()
            );
        }
    }



    @Test
    void plazasLibresPorPlantas(){

        List<plazasLibres> plazas = plazaRepositorio.plazasLibresPorPlantas();

        System.out.println("Plazas encontradas: " + plazas.size());

        for (plazasLibres plaza : plazas){
            System.out.println(
                    "Planta: " + plaza.getPlanta() +
                            " | Tipo: " + plaza.getTipo() +
                            " | Libres: " + plaza.getPlazasLibres()
            );
        }
    }


    @Autowired
    private TarifaRepositorio tarifaRepositorio;

    @Test
    void tarifaVigente() {

        tarifasVigentes tarifa = tarifaRepositorio.tarifaVigente();

        System.out.println("Tarifa vigente:");
        System.out.println("ID: " + tarifa.getIdTarifa());
        System.out.println("Minutos cortesía: " + tarifa.getMinCortesia());
        System.out.println("Precio por minuto: " + tarifa.getPrecioPorMin());
        System.out.println("Tope máximo: " + tarifa.getTopeMaximo());
        System.out.println("Fecha de aplicación: " + tarifa.getFechaAplica());
    }



    @Autowired
    private TicketsRepositorio ticketsRepositorio;

    @Test
    void importeTicket() {

        importeTicket ticket =
                ticketsRepositorio.obtenerImporteActual("1234ABC");

        System.out.println("Matrícula: " + ticket.getMatricula());
        System.out.println("Minutos: " + ticket.getMinutos());
        System.out.println("Importe actual: " + ticket.getImporte() + " €");
    }
}
