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
                    "CAST(GREATEST(0, LEAST(" +
                    "((EXTRACT(EPOCH FROM (CURRENT_TIMESTAMP - t.hora_entrada)) / 60 - tr.min_cortesia) * tr.precio_por_min), " +
                    "tr.tope_maximo" +
                    ")) AS NUMERIC(8,2)) AS importe " +
                    "FROM parkingapp.tickets t " +
                    "JOIN parkingapp.tarifa tr ON tr.id = t.id_tarifa " +
                    "WHERE t.matricula = :matricula " +
                    "AND t.estado = 'ACTIVO'",
            nativeQuery = true
    )
    Optional<importeTicket> obtenerImporteActual(
            @Param("matricula") String matricula);



    @Query(
            value = "SELECT new es.safareyes.parkingapp.dtos.listadoTickets(" +
                    "t.id, t.matricula, t.horaEntrada, t.horaSalida, " +
                    "t.estado, t.minutos, t.importe, p.numero) " +
                    "FROM Tickets t " +
                    "JOIN t.plaza p " +
                    "WHERE t.estado = COALESCE(:estado, t.estado) " +
                    "AND t.matricula = COALESCE(:matricula, t.matricula) " +
                    "AND t.horaEntrada >= COALESCE(:desde, t.horaEntrada) " +
                    "AND t.horaEntrada <= COALESCE(:hasta, t.horaEntrada) " +
                    "AND (:idUsuario IS NULL OR EXISTS (" +
                    "SELECT 1 FROM Usuarios u JOIN u.abonados a " +
                    "WHERE u.id = :idUsuario AND a = t.abonado))",
            countQuery = "SELECT COUNT(t) " +
                    "FROM Tickets t " +
                    "WHERE t.estado = COALESCE(:estado, t.estado) " +
                    "AND t.matricula = COALESCE(:matricula, t.matricula) " +
                    "AND t.horaEntrada >= COALESCE(:desde, t.horaEntrada) " +
                    "AND t.horaEntrada <= COALESCE(:hasta, t.horaEntrada) " +
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
            Pageable pageable
    );


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



    @Query(
            nativeQuery = true,
            value = "SELECT CAST(t.hora_salida AS DATE) AS dia, " +
                    "COUNT(*) AS num_tickets, " +
                    "SUM(t.importe) AS recaudacion " +
                    "FROM parkingapp.tickets t " +
                    "WHERE t.estado = 'PAGADO' " +
                    "AND t.hora_salida >= :desde " +
                    "AND t.hora_salida <= :hasta " +
                    "GROUP BY CAST(t.hora_salida AS DATE) " +
                    "ORDER BY dia"
    )
    List<recaudacionDia> recaudacionPorDia(
            @Param("desde") LocalDateTime desde,
            @Param("hasta") LocalDateTime hasta);
}
