package es.safareyes.parkingapp.controllers;

import es.safareyes.parkingapp.Service.ticketService;
import es.safareyes.parkingapp.dtos.detalleTicket;
import es.safareyes.parkingapp.dtos.importeTicket;
import es.safareyes.parkingapp.dtos.listadoTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/tickets")
public class ticketController {

    @Autowired
    private ticketService ticketService;

    //Lista de tique con filtro
    @GetMapping
    public Page<listadoTickets> listarTickets(
            @RequestParam(required = false)String estado,
            @RequestParam(required = false)String matricula,
            @RequestParam(required = false)LocalDateTime desde,
            @RequestParam(required = false)LocalDateTime hasta,
            @RequestParam(required = false)Integer idUsuario,
            Pageable pageable) {
        return ticketService.listarTickets(estado, matricula, desde, hasta, idUsuario, pageable);
    }




    //BuscarPormatricula el importe
    @GetMapping("/{matricula}/importe")
    public ResponseEntity<importeTicket> obtenerImporteActual(
            @PathVariable String matricula) {
        return ticketService.obtenerImporteActual(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }







    // Consultar detalle de un ticket
    @GetMapping("/{id}")
    public ResponseEntity<detalleTicket> detalleTicket(
            @PathVariable Integer id) {

        return ticketService.obtenerDetalleTicket(id, null)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
