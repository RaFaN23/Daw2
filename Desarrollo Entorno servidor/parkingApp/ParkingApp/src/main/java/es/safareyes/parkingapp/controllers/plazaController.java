package es.safareyes.parkingapp.controllers;


import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.Service.plazaService;
import es.safareyes.parkingapp.dtos.PlazaDTO;
import es.safareyes.parkingapp.dtos.altaPlazaDTO;
import es.safareyes.parkingapp.dtos.ocupacionPlanta;
import es.safareyes.parkingapp.dtos.plazasLibres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/plazas")
public class plazaController {

    @Autowired
    private plazaService plazaService;

    //tener todas las plazas con filtros
    @GetMapping
    public Page<PlazaDTO> listar(
            @RequestParam(required = false) Integer planta,
            @RequestParam(required = false) String tipo,
            @RequestParam(required = false) String estado,
            Pageable pageable) {
        return plazaService.listar(planta, tipo, estado, pageable);
    }


    //plazas libres por planta y tipo
    @GetMapping("disponibilidad")
    public List<plazasLibres> disponibilidad(
            @RequestParam(required = false) Integer planta,
            @RequestParam(required = false) String tipo
    ) {
        return plazaService.listarLibres(planta, tipo);
    }



    //Añadir plaza
    @PostMapping
    public ResponseEntity<Plaza> altaPlaza(@RequestBody altaPlazaDTO datos) {

        Plaza plaza = new Plaza();

        plaza.setNumero(datos.getNumero());
        plaza.setPlanta(datos.getPlanta());
        plaza.setTipo(datos.getTipo());
        plaza.setEstado(datos.getEstado());

        Plaza nuevaPlaza = plazaService.guardarPlaza(plaza);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPlaza);
    }
    
}
