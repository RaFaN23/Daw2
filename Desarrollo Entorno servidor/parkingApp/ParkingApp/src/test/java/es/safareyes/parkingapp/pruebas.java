package es.safareyes.parkingapp;
import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.Modelos.Tarifa;
import es.safareyes.parkingapp.Repositorio.PlazaRepositorio;
import es.safareyes.parkingapp.Repositorio.TarifaRepositorio;
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
    void tarifasVigentes(){

        List<tarifasVigentes> tarifas = tarifaRepositorio.tarifasVigentes();

        System.out.println("Tarifas vigentes: " + tarifas.size());

        for (tarifasVigentes tarifa : tarifas) {

            System.out.println(
                    "Tarifa: " + tarifa.getIdTarifa() +
                            " | Matrícula: " + tarifa.getMatricula() +
                            " | Usuario: " + tarifa.getNombreUsuario()
            );
        }
    }
}
