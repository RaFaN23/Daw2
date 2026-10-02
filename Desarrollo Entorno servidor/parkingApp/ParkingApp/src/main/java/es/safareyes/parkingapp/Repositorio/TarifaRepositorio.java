package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepositorio extends JpaRepository<Tarifa,Integer> {
}
