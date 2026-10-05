package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Tickets;
import es.safareyes.parkingapp.dtos.importeTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}