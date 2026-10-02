package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Promocion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionRepositorio extends JpaRepository<Promocion,Integer> {
}
