package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Abonado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonadoRepositorio extends JpaRepository<Abonado,Integer> {
}
