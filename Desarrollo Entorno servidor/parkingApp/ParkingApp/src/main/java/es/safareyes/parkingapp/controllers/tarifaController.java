package es.safareyes.parkingapp.controllers;

import es.safareyes.parkingapp.Service.tarifaService;
import es.safareyes.parkingapp.dtos.tarifasVigentes;
import org.springframework.beans.factory.annotation.Autowired;
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
}