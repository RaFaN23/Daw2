package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Repositorio.DescuentoRepositorio;
import es.safareyes.parkingapp.Repositorio.TicketsRepositorio;
import es.safareyes.parkingapp.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ticketService {

    @Autowired
    private TicketsRepositorio ticketsRepositorio;
    @Autowired
    private DescuentoRepositorio descuentoRepositorio;


    //Buscar importe por matri
    public Optional<importeTicket> obtenerImporteActual(String matricula) {
        return ticketsRepositorio.obtenerImporteActual(matricula);
    }
    //Lista de tique con filtro

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


    //Recaudacion por dia
    public List<recaudacionDia> recaudacionPorDia(
            @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime desde,
            @RequestParam(required = false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime hasta) {
        return ticketsRepositorio.recaudacionPorDia(desde, hasta);
    }




    // Consultar detalle de un ticket con sus descuentos
    public Optional<detalleTicket> obtenerDetalleTicket(Integer id, Integer idUsuario) {

        Optional<detalleTicketBase> ticketBase =
                ticketsRepositorio.detalleTicketBase(id, idUsuario);

        if (ticketBase.isEmpty()) {
            return Optional.empty();
        }

        detalleTicketBase ticket = ticketBase.get();

        List<descuentoDTO> descuentos =
                descuentoRepositorio.buscarDescuentosPorTicket(id);

        detalleTicket detalle = new detalleTicket(
                ticket.getId(),
                ticket.getMatricula(),
                ticket.getHoraEntrada(),
                ticket.getHoraSalida(),
                ticket.getEstado(),
                ticket.getMinutos(),
                ticket.getNumeroPlaza(),
                ticket.getPlanta(),
                ticket.getMinCortesia(),
                ticket.getPrecioPorMin(),
                descuentos,
                ticket.getDescuento(),
                ticket.getImporteDescuento(),
                ticket.getImporte()
        );

        return Optional.of(detalle);
    }
}


