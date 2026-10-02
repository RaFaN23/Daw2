package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketsRepositorio extends JpaRepository<Tickets,Integer> {
}
