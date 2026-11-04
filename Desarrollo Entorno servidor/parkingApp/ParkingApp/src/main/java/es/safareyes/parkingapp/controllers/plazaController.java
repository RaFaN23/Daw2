package es.safareyes.parkingapp.controllers;


import es.safareyes.parkingapp.Service.plazaService;
import es.safareyes.parkingapp.dtos.PlazaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/plazas")
public class plazaController {

    @Autowired
    private plazaService plazaService;


    @GetMapping
    public Page<PlazaDTO> listar(
            @RequestParam(required = false) Integer planta,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String estado,
            Pageable pageable) {
        return plazaService.listar(planta, tipo, estado, pageable);
    }
}
