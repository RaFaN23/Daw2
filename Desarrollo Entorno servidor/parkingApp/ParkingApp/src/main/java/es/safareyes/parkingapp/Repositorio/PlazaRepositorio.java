package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Plaza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlazaRepositorio extends JpaRepository<Plaza,Integer> {
}
