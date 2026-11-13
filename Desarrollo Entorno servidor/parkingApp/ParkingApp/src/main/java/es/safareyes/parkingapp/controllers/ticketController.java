package es.safareyes.parkingapp.controllers;

import es.safareyes.parkingapp.Service.ticketService;
import es.safareyes.parkingapp.dtos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/tickets")
public class ticketController {

    @Autowired
    private ticketService ticketService;


    // Lista de tickets con filtros
    @GetMapping
    public Page<listadoTickets> listarTickets(
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String matricula,
            @RequestParam(required = false) LocalDateTime desde,
            @RequestParam(required = false) LocalDateTime hasta,
            @RequestParam(required = false) Integer idUsuario,
            Pageable pageable) {

        return ticketService.listarTickets(
                estado, matricula, desde, hasta, idUsuario, pageable
        );
    }


    // Buscar el importe actual por matrícula
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


    // Registrar entrada de un vehículo
    @PostMapping("/entrada")
    public ResponseEntity<entradaTicketRespuestaDTO> registrarEntrada(
            @Valid @RequestBody entradaTicketDTO datos) {

        entradaTicketRespuestaDTO respuesta =
                ticketService.registrarEntrada(datos);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(respuesta);
    }


    // Aplicar una promoción a un ticket
    @PostMapping("/{id}/descuentos")
    public ResponseEntity<descuentoAplicadoDTO> aplicarDescuento(
            @PathVariable Integer id,
            @Valid @RequestBody aplicarDescuentoDTO datos) {

        descuentoAplicadoDTO respuesta =
                ticketService.aplicarDescuento(id, datos);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(respuesta);
    }


    // Pagar un ticket
    @PostMapping("/pagar")
    public ResponseEntity<pagoTicketRespuestaDTO> pagarTicket(
            @Valid @RequestBody pagarTicketDTO datos) {

        pagoTicketRespuestaDTO ticketPagado =
                ticketService.pagarTicket(datos);

        return ResponseEntity.ok(ticketPagado);
    }
}