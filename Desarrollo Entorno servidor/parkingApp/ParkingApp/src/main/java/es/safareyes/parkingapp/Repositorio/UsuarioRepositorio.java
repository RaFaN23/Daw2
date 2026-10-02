package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios, Integer> {

    @Query("SELECT u FROM Usuarios u WHERE u.Contrasenya LIKE %:contrasenya%")
    List<Usuarios> buscarPorContrasenya(@Param("contrasenya") String contrasenya);
}