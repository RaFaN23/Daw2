package es.safareyes.parkingapp.Repositorio;
import es.safareyes.parkingapp.Modelos.Plaza;
import es.safareyes.parkingapp.dtos.plazasLibres;
import es.safareyes.parkingapp.dtos.ocupacionPlanta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlazaRepositorio extends JpaRepository<Plaza, Integer> {

    //Plazas libres por planta y tipo
    @Query("SELECT p FROM Plaza p " +
            "WHERE (:planta IS NULL OR p.planta = :planta) " +
            "AND (:tipo IS NULL OR p.tipo = :tipo) " +
            "AND (:estado IS NULL OR p.estado = :estado)")
    Page<Plaza> buscarPlazasFiltradas(@Param("planta") Integer planta,
                                      @Param("tipo") String tipo,
                                      @Param("estado") String estado,
                                      Pageable pageable);

    @Query(
            nativeQuery = true,
            value = "SELECT p.* " +
                    "FROM parkingapp.plaza p " +
                    "ORDER BY p.planta, p.tipo, p.estado"
    )
    List<Plaza> buscarPlazas();



    //plazas libres por planta y tipo
    @Query("SELECT new es.safareyes.parkingapp.dtos.plazasLibres(" +
            "p.planta, p.tipo, COUNT(p)) " +
            "FROM Plaza p " +
            "WHERE p.estado = 'libre' " +
            "AND (:planta IS NULL OR p.planta = :planta) " +
            "AND (:tipo IS NULL OR p.tipo = :tipo) " +
            "GROUP BY p.planta, p.tipo " +
            "ORDER BY p.planta, p.tipo")
    List<plazasLibres> plazasLibresPorPlantas(
            @Param("planta") Integer planta,
            @Param("tipo") String tipo);




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