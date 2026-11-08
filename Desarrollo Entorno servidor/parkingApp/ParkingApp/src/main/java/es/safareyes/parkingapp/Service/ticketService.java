package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Repositorio.TicketsRepositorio;
import es.safareyes.parkingapp.converter.ImporteTicketsMapper;
import es.safareyes.parkingapp.dtos.importeTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ticketService {

    @Autowired
    private TicketsRepositorio ticketsRepositorio;
    @Autowired
    private ImporteTicketsMapper importeTicketsMapper;

    public Optional<importeTicket> obtenerImporteActual(String matricula) {
        return ticketsRepositorio.obtenerImporteActual(matricula);
    }
}
