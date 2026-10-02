package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Abonado_usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Abonado_usuarioRepositorio extends JpaRepository<Abonado_usuario,Integer> {
}
