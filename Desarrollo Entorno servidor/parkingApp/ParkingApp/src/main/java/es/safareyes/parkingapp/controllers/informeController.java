package es.safareyes.parkingapp.controllers;

import es.safareyes.parkingapp.Service.plazaService;
import es.safareyes.parkingapp.Service.ticketService;
import es.safareyes.parkingapp.dtos.ocupacionPlanta;
import es.safareyes.parkingapp.dtos.recaudacionDia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/informes/")
public class informeController {
    @Autowired
    private plazaService plazaService;
    @Autowired
    private ticketService ticketService;

    //recaudacion por dia y hora
    @GetMapping("recaudacion")
    public List<recaudacionDia> recaudacion(
            @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        return ticketService.recaudacionPorDia(desde, hasta);
    }

    //ocupacion planta
    @GetMapping("ocupacion")
    public List<ocupacionPlanta> ocupacionPlanta() {
        return plazaService.ocupacionPlanta();
    }

}
