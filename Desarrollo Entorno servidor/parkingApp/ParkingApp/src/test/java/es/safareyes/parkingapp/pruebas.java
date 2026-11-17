package es.safareyes.parkingapp;

import es.safareyes.parkingapp.Service.*;
import es.safareyes.parkingapp.dtos.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class pruebas {

    @Autowired
    private plazaService plazaService;

    @Autowired
    private tarifaService tarifaService;

    @Autowired
    private ticketService ticketService;

    @Autowired
    private promocionesService promocionesService;


    // ==========================================
    // PRUEBAS DE PLAZAS
    // ==========================================

    // GET /api/v1/plazas
    @Test
    public void listarPlazas() {

        Page<PlazaDTO> plazas = plazaService.listar(
                null,
                null,
                null,
                PageRequest.of(0, 10)
        );

        System.out.println("===== LISTADO DE PLAZAS =====");

        plazas.getContent().forEach(System.out::println);

        assertNotNull(plazas);
    }


    // GET /api/v1/plazas/disponibilidad
    @Test
    public void plazasDisponibles() {

        List<plazasLibres> plazas = plazaService.listarLibres(
                null,
                null
        );

        System.out.println("===== PLAZAS DISPONIBLES =====");

        plazas.forEach(System.out::println);

        assertNotNull(plazas);
    }


    // GET /api/v1/informes/ocupacion
    @Test
    public void ocupacionPorPlanta() {

        List<ocupacionPlanta> ocupacion =
                plazaService.ocupacionPlanta();

        System.out.println("===== OCUPACION POR PLANTA =====");

        ocupacion.forEach(System.out::println);

        assertNotNull(ocupacion);
    }


    // ==========================================
    // PRUEBAS DE TARIFAS
    // ==========================================

    // GET /api/v1/tarifas/vigente
    @Test
    public void tarifaVigente() {

        tarifasVigentes tarifa =
                tarifaService.obtenerTarifaVigente();

        System.out.println("===== TARIFA VIGENTE =====");

        System.out.println(tarifa);

        assertNotNull(tarifa);
    }


    // GET /api/v1/tarifas
    @Test
    public void listarTodasLasTarifas() {

        List<tarifasVigentes> tarifas =
                tarifaService.listarTodasLasTarifas();

        System.out.println("===== TODAS LAS TARIFAS =====");

        tarifas.forEach(System.out::println);

        assertNotNull(tarifas);
    }


    // ==========================================
    // PRUEBAS DE TICKETS
    // ==========================================

    // GET /api/v1/tickets/{matricula}/importe
    @Test
    public void consultarImporteTicket() {

        Optional<importeTicket> importe =
                ticketService.obtenerImporteActual("0123BCD");

        System.out.println("===== IMPORTE DEL TICKET =====");

        if (importe.isPresent()) {
            System.out.println(importe.get());
        } else {
            System.out.println("No existe un ticket activo para esa matrícula");
        }

        assertNotNull(importe);
    }


    // GET /api/v1/tickets
    @Test
    public void listarTickets() {

        Page<listadoTickets> tickets =
                ticketService.listarTickets(
                        null,
                        null,
                        null,
                        null,
                        null,
                        PageRequest.of(0, 10)
                );

        System.out.println("===== LISTADO DE TICKETS =====");

        tickets.getContent().forEach(System.out::println);

        assertNotNull(tickets);
    }


    // GET /api/v1/tickets/{id}
    @Test
    public void consultarDetalleTicket() {

        Optional<detalleTicket> ticket =
                ticketService.obtenerDetalleTicket(16, null);

        System.out.println("===== DETALLE DEL TICKET =====");

        if (ticket.isPresent()) {
            System.out.println(ticket.get());
        } else {
            System.out.println("No se ha encontrado el ticket");
        }

        assertNotNull(ticket);
    }


    // GET /api/v1/informes/recaudacion
    @Test
    public void recaudacionPorDia() {

        List<recaudacionDia> recaudacion =
                ticketService.recaudacionPorDia(
                        LocalDateTime.of(2026, 1, 1, 0, 0),
                        LocalDateTime.now()
                );

        System.out.println("===== RECAUDACION POR DIA =====");

        recaudacion.forEach(System.out::println);

        assertNotNull(recaudacion);
    }


    // ==========================================
    // PRUEBAS DE PROMOCIONES
    // ==========================================

    // GET /api/v1/promociones
    @Test
    public void catalogoPromociones() {

        List<promocionesDTO> promociones =
                promocionesService.catalogoPromociones();

        System.out.println("===== CATALOGO DE PROMOCIONES =====");

        promociones.forEach(System.out::println);

        assertNotNull(promociones);
    }

}