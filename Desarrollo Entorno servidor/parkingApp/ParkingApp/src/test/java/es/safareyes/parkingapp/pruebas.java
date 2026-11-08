package es.safareyes.parkingapp;
import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.Modelos.Promocion;
import es.safareyes.parkingapp.Modelos.Tarifa;
import es.safareyes.parkingapp.Repositorio.PlazaRepositorio;
import es.safareyes.parkingapp.Repositorio.PromocionRepositorio;
import es.safareyes.parkingapp.Repositorio.TarifaRepositorio;
import es.safareyes.parkingapp.Repositorio.TicketsRepositorio;
import es.safareyes.parkingapp.dtos.detalleTicket;
import es.safareyes.parkingapp.dtos.importeTicket;
import es.safareyes.parkingapp.dtos.listadoTickets;
import es.safareyes.parkingapp.dtos.ocupacionPlanta;
import es.safareyes.parkingapp.dtos.recaudacionDia;
import es.safareyes.parkingapp.dtos.plazasLibres;
import es.safareyes.parkingapp.dtos.tarifasVigentes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class pruebas {

//    @Autowired
//    private PlazaRepositorio plazaRepositorio;
//    @Test
//    void buscarPlaza(){
//        List<Plaza> plazas = plazaRepositorio.buscarPlazas();
//        System.out.println("plazas encontrados: " + plazas.size());
//
//        for (Plaza plaza : plazas) {
//            System.out.println(
//                    "Planta: " + plaza.getPlanta() +
//                            " | Tipo: " + plaza.getTipo() +
//                            " | Estado: " + plaza.getEstado()
//            );
//        }
//    }



//    @Test
//    void plazasLibresPorPlantas(){
//
//        List<plazasLibres> plazas = plazaRepositorio.plazasLibresPorPlantas();
//
//        System.out.println("Plazas encontradas: " + plazas.size());
//
//        for (plazasLibres plaza : plazas){
//            System.out.println(
//                    "Planta: " + plaza.getPlanta() +
//                            " | Tipo: " + plaza.getTipo() +
//                            " | Libres: " + plaza.getPlazasLibres()
//            );
//        }
//    }


//    @Autowired
//    private TarifaRepositorio tarifaRepositorio;
//
//    @Test
//    void tarifaVigente() {
//
//        tarifasVigentes tarifa = tarifaRepositorio.tarifaVigente();
//
//        System.out.println("Tarifa vigente:");
//        System.out.println("ID: " + tarifa.getIdTarifa());
//        System.out.println("Minutos cortesía: " + tarifa.getMinCortesia());
//        System.out.println("Precio por minuto: " + tarifa.getPrecioPorMin());
//        System.out.println("Tope máximo: " + tarifa.getTopeMaximo());
//        System.out.println("Fecha de aplicación: " + tarifa.getFechaAplica());
//    }
//
//
//
//    @Autowired
//    private TicketsRepositorio ticketsRepositorio;
//
//    @Test
//    void importeTicket() {
//
//        importeTicket ticket =
//                ticketsRepositorio.obtenerImporteActual("1234ABC");
//
//        System.out.println("Matrícula: " + ticket.getMatricula());
//        System.out.println("Minutos: " + ticket.getMinutos());
//        System.out.println("Importe actual: " + ticket.getImporte() + " €");
//    }
//
//
//    @Test
//    void listarTicketsAdmin() {
//
//        Page<listadoTickets> pagina = ticketsRepositorio.listarTickets(
//                null, null, null, null, null,
//                PageRequest.of(0, 5, Sort.by("horaEntrada").descending()));
//
//        System.out.println("Total tickets: " + pagina.getTotalElements()
//                + " | Páginas: " + pagina.getTotalPages());
//
//        for (listadoTickets t : pagina.getContent()) {
//            System.out.println(
//                    "ID: " + t.getId() +
//                            " | Matrícula: " + t.getMatricula() +
//                            " | Estado: " + t.getEstado() +
//                            " | Entrada: " + t.getHoraEntrada() +
//                            " | Plaza: " + t.getNumeroPlaza() +
//                            " | Importe: " + t.getImporte() + " €"
//            );
//        }
//    }
//
//    @Test
//    void listarTicketsAbonado() {
//
//        Page<listadoTickets> pagina = ticketsRepositorio.listarTickets(
//                null, null, null, null, 1,
//                PageRequest.of(0, 5));
//
//        System.out.println("Tickets del usuario 1: " + pagina.getTotalElements());
//
//        for (listadoTickets t : pagina.getContent()) {
//            System.out.println(
//                    "ID: " + t.getId() +
//                            " | Matrícula: " + t.getMatricula() +
//                            " | Estado: " + t.getEstado()
//            );
//        }
//    }
//
//
//
//    @Test
//    void detalleTicket() {
//
//        detalleTicket t = ticketsRepositorio.detalleTicket(3, null).orElse(null);
//
//        if (t == null) {
//            System.out.println("Ticket no encontrado");
//            return;
//        }
//
//        System.out.println("ID: " + t.getId());
//        System.out.println("Matrícula: " + t.getMatricula());
//        System.out.println("Entrada: " + t.getHoraEntrada() + " | Salida: " + t.getHoraSalida());
//        System.out.println("Estado: " + t.getEstado() + " | Minutos: " + t.getMinutos());
//        System.out.println("Plaza: " + t.getNumeroPlaza() + " (planta " + t.getPlanta() + ")");
//        System.out.println("Tarifa: " + t.getPrecioPorMin() + " €/min, cortesía " + t.getMinCortesia() + " min");
//        System.out.println("Promoción: " + t.getNombrePromocion() + " (" + t.getTipoPromocion() + ")");
//        System.out.println("Descuento: " + t.getDescuento() + " | Importe descontado: " + t.getImporteDescuento() + " €");
//        System.out.println("Importe final: " + t.getImporte() + " €");
//
//        System.out.println("¿Usuario 1 ve el ticket 3? "
//                + ticketsRepositorio.detalleTicket(3, 1).isPresent());
//    }
//
//
//
//    @Autowired
//    private PromocionRepositorio promocionRepositorio;
//
//    @Test
//    void catalogoPromociones() {
//
//        List<Promocion> promociones = promocionRepositorio.catalogoPromociones();
//
//        System.out.println("Promociones encontradas: " + promociones.size());
//
//        for (Promocion p : promociones) {
//            System.out.println(
//                    "ID: " + p.getId() +
//                            " | Nombre: " + p.getNombre() +
//                            " | Tipo: " + p.getTipo() +
//                            " | Descuento: " + p.getMinDescuento()
//            );
//        }
//    }
//
//
//
//    @Test
//    void recaudacionPorDia() {
//
//        List<recaudacionDia> dias = ticketsRepositorio.recaudacionPorDia(
//                LocalDate.of(2026, 9, 1),
//                LocalDate.of(2026, 9, 30));
//
//        System.out.println("Días con recaudación: " + dias.size());
//
//        for (recaudacionDia d : dias) {
//            System.out.println(
//                    "Día: " + d.getDia() +
//                            " | Tickets: " + d.getNumTickets() +
//                            " | Recaudación: " + d.getRecaudacion() + " €"
//            );
//        }
//    }


//
//    @Test
//    void ocupacionPorPlanta() {
//
//        List<ocupacionPlanta> plantas = plazaRepositorio.ocupacionPorPlanta();
//
//        System.out.println("Plantas: " + plantas.size());
//
//        for (ocupacionPlanta o : plantas) {
//            System.out.println(
//                    "Planta: " + o.getPlanta() +
//                            " | Plazas: " + o.getTotalPlazas() +
//                            " | Ocupadas: " + o.getPlazasOcupadas() +
//                            " | Ocupación: " + o.getPorcentajeOcupacion() + " %" +
//                            " | Estancia media: " + o.getEstanciaMedia() + " min"
//            );
//        }
//    }
}
