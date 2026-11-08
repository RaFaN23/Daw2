package es.safareyes.parkingapp.controllers;

import es.safareyes.parkingapp.Service.ticketService;
import es.safareyes.parkingapp.dtos.importeTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
public class ticketController {

    @Autowired
    private ticketService ticketService;

    @GetMapping("/{matricula}/importe")
    public ResponseEntity<importeTicket> obtenerImporteActual(
            @PathVariable String matricula) {
        return ticketService.obtenerImporteActual(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
