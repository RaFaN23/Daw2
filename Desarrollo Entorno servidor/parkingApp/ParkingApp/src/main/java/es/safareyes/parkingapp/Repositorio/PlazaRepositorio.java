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





}