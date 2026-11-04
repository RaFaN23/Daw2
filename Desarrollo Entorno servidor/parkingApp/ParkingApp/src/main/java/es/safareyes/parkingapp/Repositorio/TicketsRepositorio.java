package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Tickets;
import es.safareyes.parkingapp.dtos.detalleTicket;
import es.safareyes.parkingapp.dtos.importeTicket;
import es.safareyes.parkingapp.dtos.listadoTickets;
import es.safareyes.parkingapp.dtos.recaudacionDia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TicketsRepositorio extends JpaRepository<Tickets, Integer> {

    @Query(
            value = "SELECT " +
                    "t.matricula AS matricula, " +
                    "CAST(EXTRACT(EPOCH FROM (CURRENT_TIMESTAMP - t.hora_entrada)) / 60 AS INTEGER) AS minutos, " +
                    "CAST(GREATEST(0, " +
                    "LEAST(" +
                    "((EXTRACT(EPOCH FROM (CURRENT_TIMESTAMP - t.hora_entrada)) / 60 - tr.min_cortesia) * tr.precio_por_min), " +
                    "tr.tope_maximo" +
                    ")) AS NUMERIC(8,2)) AS importe " +
                    "FROM parkingapp.tickets t " +
                    "JOIN parkingapp.tarifa tr ON tr.id = t.id_tarifa " +
                    "WHERE t.matricula = :matricula " +
                    "AND t.estado = 'abierto'",
            nativeQuery = true
    )
    importeTicket obtenerImporteActual(String matricula);


    // GET /api/v1/tickets
    // Listado paginado con filtros (todos opcionales, null = sin filtrar).
    // idUsuario = null -> ADMIN / OPERADOR (ven todos)
    // idUsuario = X    -> ABONADO (solo ve los tickets de sus abonos)
    @Query(
            value = "SELECT new es.safareyes.parkingapp.dtos.listadoTickets(" +
                    "t.id, t.matricula, t.horaEntrada, t.horaSalida, " +
                    "t.estado, t.minutos, t.importe, p.numero) " +
                    "FROM Tickets t " +
                    "JOIN t.plaza p " +
                    "WHERE (:estado IS NULL OR t.estado = :estado) " +
                    "AND (:matricula IS NULL OR t.matricula = :matricula) " +
                    "AND (:desde IS NULL OR t.horaEntrada >= :desde) " +
                    "AND (:hasta IS NULL OR t.horaEntrada <= :hasta) " +
                    "AND (:idUsuario IS NULL OR EXISTS (" +
                    "SELECT 1 FROM Usuarios u JOIN u.abonados a " +
                    "WHERE u.id = :idUsuario AND a = t.abonado))",
            countQuery = "SELECT COUNT(t) " +
                    "FROM Tickets t " +
                    "WHERE (:estado IS NULL OR t.estado = :estado) " +
                    "AND (:matricula IS NULL OR t.matricula = :matricula) " +
                    "AND (:desde IS NULL OR t.horaEntrada >= :desde) " +
                    "AND (:hasta IS NULL OR t.horaEntrada <= :hasta) " +
                    "AND (:idUsuario IS NULL OR EXISTS (" +
                    "SELECT 1 FROM Usuarios u JOIN u.abonados a " +
                    "WHERE u.id = :idUsuario AND a = t.abonado))"
    )
    Page<listadoTickets> listarTickets(
            @Param("estado") String estado,
            @Param("matricula") String matricula,
            @Param("desde") LocalDateTime desde,
            @Param("hasta") LocalDateTime hasta,
            @Param("idUsuario") Integer idUsuario,
            Pageable pageable);


    // GET /api/v1/tickets/{id}
    // Detalle con descuentos aplicados.
    // idUsuario = null -> ADMIN / OPERADOR
    // idUsuario = X    -> ABONADO (solo si el ticket es suyo, si no devuelve vacío)
    @Query(
            "SELECT new es.safareyes.parkingapp.dtos.detalleTicket(" +
                    "t.id, t.matricula, t.horaEntrada, t.horaSalida, t.estado, t.minutos, " +
                    "p.numero, p.planta, " +
                    "tr.minCortesia, tr.precioPorMin, " +
                    "pr.nombre, pr.tipo, " +
                    "t.descuento, t.importeDescuento, t.importe) " +
                    "FROM Tickets t " +
                    "JOIN t.plaza p " +
                    "JOIN t.tarifa tr " +
                    "LEFT JOIN t.promocion pr " +
                    "WHERE t.id = :id " +
                    "AND (:idUsuario IS NULL OR EXISTS (" +
                    "SELECT 1 FROM Usuarios u JOIN u.abonados a " +
                    "WHERE u.id = :idUsuario AND a = t.abonado))"
    )
    Optional<detalleTicket> detalleTicket(
            @Param("id") Integer id,
            @Param("idUsuario") Integer idUsuario);


    // GET /api/v1/informes/recaudacion?desde=&hasta=
    // Recaudación por día (solo tickets cerrados, por fecha de salida)
    @Query(
            nativeQuery = true,
            value = "SELECT CAST(t.hora_salida AS DATE) AS dia, " +
                    "COUNT(*) AS num_tickets, " +
                    "SUM(t.importe) AS recaudacion " +
                    "FROM parkingapp.tickets t " +
                    "WHERE t.estado = 'cerrado' " +
                    "AND CAST(t.hora_salida AS DATE) >= :desde " +
                    "AND CAST(t.hora_salida AS DATE) <= :hasta " +
                    "GROUP BY CAST(t.hora_salida AS DATE) " +
                    "ORDER BY dia"
    )
    List<recaudacionDia> recaudacionPorDia(
            @Param("desde") LocalDate desde,
            @Param("hasta") LocalDate hasta);
}
