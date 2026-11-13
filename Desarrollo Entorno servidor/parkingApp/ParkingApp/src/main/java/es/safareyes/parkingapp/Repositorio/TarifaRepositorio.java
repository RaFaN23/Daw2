package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.dtos.tarifasVigentes;
import es.safareyes.parkingapp.Modelos.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TarifaRepositorio extends JpaRepository<Tarifa, Integer> {

    // Obtener la tarifa vigente actualmente
    @Query(
            value = "SELECT " +
                    "t.id AS idTarifa, " +
                    "t.min_cortesia AS minCortesia, " +
                    "t.precio_por_min AS precioPorMin, " +
                    "t.tope_maximo AS topeMaximo, " +
                    "t.fecha_aplica AS fechaAplica " +
                    "FROM parkingapp.tarifa t " +
                    "WHERE t.fecha_aplica <= CURRENT_DATE " +
                    "ORDER BY t.fecha_aplica DESC " +
                    "LIMIT 1",
            nativeQuery = true
    )
    tarifasVigentes tarifaVigente();

    // Obtener todas las tarifas registradas
    @Query(
            value = "SELECT " +
                    "t.id AS idTarifa, " +
                    "t.min_cortesia AS minCortesia, " +
                    "t.precio_por_min AS precioPorMin, " +
                    "t.tope_maximo AS topeMaximo, " +
                    "t.fecha_aplica AS fechaAplica " +
                    "FROM parkingapp.tarifa t " +
                    "ORDER BY t.fecha_aplica DESC",
            nativeQuery = true
    )
    List<tarifasVigentes> listarTodasLasTarifas();



    //La tarifa mas reciente o activa para el ticket nuevo
    Optional<Tarifa> findFirstByFechaAplicaLessThanEqualOrderByFechaAplicaDesc(LocalDate fecha);
}