package es.safareyes.parkingapp.controllers;

import es.safareyes.parkingapp.Modelos.Tarifa;
import es.safareyes.parkingapp.Service.tarifaService;
import es.safareyes.parkingapp.dtos.nuevaTarifaDTO;
import es.safareyes.parkingapp.dtos.tarifasVigentes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tarifas")
public class tarifaController {

    @Autowired
    private tarifaService tarifaService;

    //tarifa vigente
    @GetMapping("/vigente")
    public tarifasVigentes obtenerTarifaVigente() {
        return tarifaService.obtenerTarifaVigente();
    }

    //todas las tarifas
    @GetMapping
    public List<tarifasVigentes> listarTodasLasTarifas() {
        return tarifaService.listarTodasLasTarifas();
    }

    //Nueva plaza
    @PostMapping
    public ResponseEntity<Tarifa> anyadirTarifa(
            @Valid @RequestBody nuevaTarifaDTO nuevaTarifa) {

        Tarifa tarifa = new Tarifa();

        tarifa.setMinCortesia(nuevaTarifa.getMinCortesia());
        tarifa.setPrecioPorMin(nuevaTarifa.getPrecioPorMin());
        tarifa.setTopeMaximo(nuevaTarifa.getTopeMaximo());
        tarifa.setFechaAplica(nuevaTarifa.getFechaAplica());

        Tarifa tarifaNueva = tarifaService.anyadirTarifa(tarifa);

        return ResponseEntity.status(HttpStatus.CREATED).body(tarifaNueva);
    }
}
