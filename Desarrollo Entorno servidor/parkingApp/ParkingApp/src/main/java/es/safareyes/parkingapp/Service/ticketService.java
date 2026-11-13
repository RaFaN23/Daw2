package es.safareyes.parkingapp.Service;

import es.safareyes.parkingapp.Modelos.*;
import es.safareyes.parkingapp.Repositorio.*;
import es.safareyes.parkingapp.dtos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ticketService {

    @Autowired
    private AbonadoRepositorio abonadoRepositorio;

    @Autowired
    private TicketsRepositorio ticketsRepositorio;

    @Autowired
    private DescuentoRepositorio descuentoRepositorio;

    @Autowired
    private PlazaRepositorio plazaRepositorio;

    @Autowired
    private TarifaRepositorio tarifaRepositorio;

    @Autowired
    private PromocionRepositorio promocionRepositorio;


    // Buscar importe por matrícula
    public Optional<importeTicket> obtenerImporteActual(String matricula) {

        return ticketsRepositorio.obtenerImporteActual(matricula);
    }


    // Lista de tickets con filtros
    public Page<listadoTickets> listarTickets(
            String estado,
            String matricula,
            LocalDateTime desde,
            LocalDateTime hasta,
            Integer idUsuario,
            Pageable pageable) {

        return ticketsRepositorio.listarTickets(
                estado, matricula, desde, hasta, idUsuario, pageable
        );
    }


    // Recaudación por día
    public List<recaudacionDia> recaudacionPorDia(
            LocalDateTime desde,
            LocalDateTime hasta) {

        return ticketsRepositorio.recaudacionPorDia(desde, hasta);
    }


    // Consultar detalle de un ticket con sus descuentos
    public Optional<detalleTicket> obtenerDetalleTicket(
            Integer id,
            Integer idUsuario) {

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


    // Registrar entrada de un vehículo
    @Transactional
    public entradaTicketRespuestaDTO registrarEntrada(
            entradaTicketDTO datos) {

        // RN-01: Comprobar si la matrícula ya tiene un ticket activo
        String matricula = datos.getMatricula().trim().toUpperCase();

        if (ticketsRepositorio.existsByMatriculaAndEstado(matricula, "ACTIVO")) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Esta matrícula ya tiene un ticket activo"
            );
        }


        // Comprobar el tipo de plaza
        String tipo = datos.getTipoPlaza();

        if (tipo == null || tipo.isBlank()) {
            tipo = "normal";
        }

        tipo = tipo.trim().toLowerCase();

        if (!tipo.equals("normal") &&
                !tipo.equals("movilidad reducida") &&
                !tipo.equals("cargador electrico")) {

            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El tipo de plaza no es válido"
            );
        }


        // Guardar la hora de entrada
        LocalDateTime horaEntrada = LocalDateTime.now();


        // RN-02 y RN-03: Buscar la primera plaza libre
        List<Plaza> plazas = plazaRepositorio.buscarPrimeraPlazaLibre(
                tipo,
                PageRequest.of(0, 1)
        );

        if (plazas.isEmpty()) {

            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "No hay plazas libres de ese tipo"
            );
        }

        Plaza plaza = plazas.get(0);


        // RN-04: Buscar la tarifa vigente en el momento de entrada
        Tarifa tarifa = tarifaRepositorio
                .findFirstByFechaAplicaLessThanEqualOrderByFechaAplicaDesc(
                        horaEntrada.toLocalDate()
                )
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNPROCESSABLE_ENTITY,
                        "No existe ninguna tarifa vigente"
                ));


        // Cambiar el estado de la plaza
        plaza.setEstado("ocupada");
        plazaRepositorio.save(plaza);


        // Crear el ticket
        Tickets ticket = new Tickets();

        ticket.setMatricula(matricula);
        ticket.setHoraEntrada(horaEntrada);
        ticket.setEstado("ACTIVO");
        ticket.setMinutos(0);
        ticket.setDescuento(BigDecimal.ZERO);
        ticket.setImporteDescuento(BigDecimal.ZERO);
        ticket.setImporte(BigDecimal.ZERO);
        ticket.setPlaza(plaza);
        ticket.setTarifa(tarifa);


        // Comprobar si la matrícula tiene un abono vigente
        Abonado abonado = abonadoRepositorio.buscarAbonadoVigente(
                matricula,
                horaEntrada.toLocalDate()
        ).orElse(null);

        ticket.setAbonado(abonado);


        // Guardar el ticket
        Tickets ticketGuardado = ticketsRepositorio.save(ticket);


        // Devolver los datos necesarios del ticket
        return new entradaTicketRespuestaDTO(
                ticketGuardado.getId(),
                ticketGuardado.getMatricula(),
                ticketGuardado.getHoraEntrada(),
                ticketGuardado.getEstado(),
                ticketGuardado.getPlaza().getNumero(),
                ticketGuardado.getPlaza().getPlanta(),
                ticketGuardado.getPlaza().getTipo(),
                ticketGuardado.getTarifa().getId()
        );
    }


    // Aplicar una promoción manual a un ticket
    @Transactional
    public descuentoAplicadoDTO aplicarDescuento(
            Integer idTicket,
            aplicarDescuentoDTO datos) {

        // Buscar y bloquear el ticket
        Tickets ticket = ticketsRepositorio.buscarPorIdBloqueado(idTicket)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No existe el ticket"
                ));

        if (!ticket.getEstado().equals("ACTIVO")) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "No se pueden aplicar descuentos a un ticket que no está activo"
            );
        }


        // Buscar la promoción
        Promocion promocion = promocionRepositorio.findById(datos.getIdPromocion())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No existe la promoción"
                ));


        // Comprobar que la promoción no se haya aplicado anteriormente
        if (descuentoRepositorio.existsByTicketIdAndPromocionId(
                idTicket, datos.getIdPromocion())) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Esta promoción ya se ha aplicado a este ticket"
            );
        }


        // Sumar los minutos de descuento que ya tiene el ticket
        Long minutosActuales =
                descuentoRepositorio.sumarMinutosDescuento(idTicket);


        // Obtener los minutos de la nueva promoción
        Integer minutosPromocion = promocion.getMinDescuento();

        if (minutosActuales + minutosPromocion > 180) {

            throw new ResponseStatusException(
                    HttpStatus.UNPROCESSABLE_ENTITY,
                    "El descuento no puede superar los 180 minutos por ticket"
            );
        }


        // Crear el descuento
        LocalDateTime fecha = LocalDateTime.now();

        Descuento descuento = new Descuento();

        descuento.setTicket(ticket);
        descuento.setPromocion(promocion);
        descuento.setMinutosAplicados(minutosPromocion);
        descuento.setFechaAplicacion(fecha);

        descuentoRepositorio.save(descuento);


        // Calcular el total de minutos promocionados
        Integer totalMinutos = minutosActuales.intValue() + minutosPromocion;


        // Devolver la respuesta
        return new descuentoAplicadoDTO(
                ticket.getId(),
                promocion.getId(),
                promocion.getNombre(),
                minutosPromocion,
                totalMinutos,
                fecha
        );
    }


    // Pagar un ticket
    @Transactional
    public pagoTicketRespuestaDTO pagarTicket(pagarTicketDTO datos) {

        // Obtener la matrícula
        String matricula = datos.getMatricula().trim().toUpperCase();


        // Buscar y bloquear el ticket activo
        Tickets ticket = ticketsRepositorio.buscarTicketActivoBloqueado(matricula)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No existe un ticket activo para esta matrícula"
                ));


        // Guardar la hora de salida
        LocalDateTime horaSalida = LocalDateTime.now();


        // Calcular los minutos aparcados, redondeando hacia arriba
        long segundos = java.time.Duration.between(
                ticket.getHoraEntrada(),
                horaSalida
        ).getSeconds();

        Integer minutos = (int) Math.ceil(segundos / 60.0);


        // Obtener los minutos de promociones aplicadas
        Long minutosDescuento = descuentoRepositorio.sumarMinutosDescuento(
                ticket.getId()
        );


        // Comprobar si el cliente tiene un abono vigente
        boolean esAbonado = ticket.getAbonado() != null
                && !horaSalida.toLocalDate().isBefore(ticket.getAbonado().getFechaIni())
                && !horaSalida.toLocalDate().isAfter(ticket.getAbonado().getFechaFin());


        BigDecimal importe = BigDecimal.ZERO;
        BigDecimal importeDescuento = BigDecimal.ZERO;


        // Si no es abonado, calcular el importe
        if (!esAbonado) {

            // Calcular cuánto habría pagado sin promociones
            BigDecimal importeSinPromociones = calcularImporte(
                    minutos,
                    0,
                    ticket.getTarifa()
            );


            // Calcular cuánto debe pagar con las promociones
            importe = calcularImporte(
                    minutos,
                    minutosDescuento.intValue(),
                    ticket.getTarifa()
            );


            // Calcular el dinero ahorrado con las promociones
            importeDescuento = importeSinPromociones.subtract(importe);

            if (importeDescuento.compareTo(BigDecimal.ZERO) < 0) {
                importeDescuento = BigDecimal.ZERO;
            }
        }


        // Guardar los datos del cobro
        ticket.setHoraSalida(horaSalida);
        ticket.setMinutos(minutos);
        ticket.setDescuento(BigDecimal.valueOf(minutosDescuento));
        ticket.setImporteDescuento(importeDescuento);
        ticket.setImporte(importe);
        ticket.setEstado("PAGADO");


        // Liberar la plaza
        Plaza plaza = ticket.getPlaza();
        plaza.setEstado("libre");

        plazaRepositorio.save(plaza);
        ticketsRepositorio.save(ticket);


        // Devolver un DTO para evitar errores de carga diferida
        return new pagoTicketRespuestaDTO(
                ticket.getId(),
                ticket.getMatricula(),
                ticket.getHoraEntrada(),
                ticket.getHoraSalida(),
                ticket.getEstado(),
                ticket.getMinutos(),
                ticket.getDescuento(),
                ticket.getImporteDescuento(),
                ticket.getImporte(),
                ticket.getPlaza().getNumero()
        );
    }


    // Calcular el importe de un ticket
    private BigDecimal calcularImporte(
            Integer minutos,
            Integer minutosPromocion,
            Tarifa tarifa) {

        // Restar los minutos de promoción
        Integer minutosRestantes = Math.max(
                0, minutos - minutosPromocion
        );


        // Restar los minutos de cortesía
        Integer minutosFacturables = Math.max(
                0, minutosRestantes - tarifa.getMinCortesia()
        );


        // Si no hay minutos que cobrar, el importe es 0
        if (minutosFacturables == 0) {
            return BigDecimal.ZERO;
        }


        // Calcular el importe sin aplicar el tope
        BigDecimal importe = tarifa.getPrecioPorMin()
                .multiply(BigDecimal.valueOf(minutosFacturables));


        // Calcular los bloques de 24 horas
        Integer bloques24Horas = (int) Math.ceil(minutos / 1440.0);


        // Calcular el importe máximo permitido
        BigDecimal importeMaximo = tarifa.getTopeMaximo()
                .multiply(BigDecimal.valueOf(bloques24Horas));


        // Aplicar el tope máximo
        importe = importe.min(importeMaximo);


        // Redondear a dos decimales
        return importe.setScale(2, java.math.RoundingMode.HALF_UP);
    }
}