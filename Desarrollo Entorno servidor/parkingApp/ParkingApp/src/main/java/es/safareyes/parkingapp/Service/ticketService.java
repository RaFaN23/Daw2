package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Repositorio.TicketsRepositorio;
import es.safareyes.parkingapp.dtos.importeTicket;
import es.safareyes.parkingapp.dtos.listadoTickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ticketService {

    @Autowired
    private TicketsRepositorio ticketsRepositorio;



    //Buscar importe por matri
    public Optional<importeTicket> obtenerImporteActual(String matricula) {
        return ticketsRepositorio.obtenerImporteActual(matricula);
    }
    //Lista de tique con filtro
    @GetMapping
    public Page<listadoTickets> listarTickets(
            @RequestParam(required = false) String estado,
            @RequestParam(required = false) String matricula,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime desde,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta,
            @RequestParam(required = false) Integer idUsuario,
            Pageable pageable) {

        return ticketsRepositorio.listarTickets(
                estado, matricula, desde, hasta, idUsuario, pageable);
    }
}


