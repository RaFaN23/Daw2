package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PromocionRepositorio extends JpaRepository<Promocion,Integer> {

    // GET /api/v1/promociones
    // Catálogo de promociones (sin DTO, devuelve la entidad)
    @Query(
            nativeQuery = true,
            value = "SELECT p.* " +
                    "FROM parkingapp.promocion p " +
                    "ORDER BY p.nombre"
    )
    List<Promocion> catalogoPromociones();
}
