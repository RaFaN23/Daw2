package es.safareyes.parkingapp.Repositorio;
import es.safareyes.parkingapp.dtos.plazasLibres;
import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.dtos.plazasLibres;
import es.safareyes.parkingapp.dtos.ocupacionPlanta;
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



    // GET /api/v1/informes/ocupacion
    // Ocupación por planta y estancia media (minutos de los tickets cerrados)
    @Query(
            nativeQuery = true,
            value = "SELECT p.planta, " +
                    "COUNT(*) AS total_plazas, " +
                    "SUM(CASE WHEN p.estado = 'ocupada' THEN 1 ELSE 0 END) AS plazas_ocupadas, " +
                    "CAST(SUM(CASE WHEN p.estado = 'ocupada' THEN 1 ELSE 0 END) * 100.0 / COUNT(*) AS NUMERIC(5,2)) AS porcentaje_ocupacion, " +
                    "(SELECT CAST(AVG(t.minutos) AS NUMERIC(8,2)) " +
                    " FROM parkingapp.tickets t " +
                    " JOIN parkingapp.plaza p2 ON p2.numero = t.numero_plaza " +
                    " WHERE p2.planta = p.planta AND t.estado = 'cerrado') AS estancia_media " +
                    "FROM parkingapp.plaza p " +
                    "GROUP BY p.planta " +
                    "ORDER BY p.planta"
    )
    List<ocupacionPlanta> ocupacionPorPlanta();
}