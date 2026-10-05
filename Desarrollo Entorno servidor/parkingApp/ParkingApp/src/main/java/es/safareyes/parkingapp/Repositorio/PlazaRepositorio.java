package es.safareyes.parkingapp.Repositorio;
import es.safareyes.parkingapp.dtos.plazasLibres;
import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.dtos.plazasLibres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlazaRepositorio extends JpaRepository<Plaza, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT p.* " +
                    "FROM parkingapp.plaza p " +
                    "ORDER BY p.planta, p.tipo, p.estado"
    )
    List<Plaza> buscarPlazas();




    @Query(
            nativeQuery = true,
            value = "SELECT p.planta, p.tipo, " +
                    "COUNT(*) AS plazas_libres " +
                    "FROM parkingapp.plaza p " +
                    "WHERE p.estado = 'libre' " +
                    "GROUP BY p.planta, p.tipo " +
                    "ORDER BY p.planta, p.tipo"
    )
    List<plazasLibres> plazasLibresPorPlantas();
}