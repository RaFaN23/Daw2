package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Modelos.Tarifa;
import es.safareyes.parkingapp.Repositorio.TarifaRepositorio;
import es.safareyes.parkingapp.dtos.tarifasVigentes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tarifaService {

    @Autowired
    private TarifaRepositorio tarifaRepositorio;

    // Obtener tarifa vigente
    public tarifasVigentes obtenerTarifaVigente() {
        return tarifaRepositorio.tarifaVigente();
    }

    // Obtener todas las tarifas
    public List<tarifasVigentes> listarTodasLasTarifas() {
        return tarifaRepositorio.listarTodasLasTarifas();
    }

    //Añadir tarifa
    public Tarifa anyadirTarifa(Tarifa nuevaTarifa) {
        return tarifaRepositorio.save(nuevaTarifa);
    }

}