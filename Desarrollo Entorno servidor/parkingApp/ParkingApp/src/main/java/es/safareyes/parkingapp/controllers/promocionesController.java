package es.safareyes.parkingapp.controllers;


import es.safareyes.parkingapp.Modelos.Promocion;
import es.safareyes.parkingapp.Service.promocionesService;
import es.safareyes.parkingapp.dtos.promocionesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/promociones")
public class promocionesController {


    @Autowired
    private promocionesService promocionesService;

    @GetMapping
    public List<promocionesDTO> catalogoPromociones() {
        return promocionesService.catalogoPromociones();
    }
}
