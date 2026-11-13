package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Abonado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AbonadoRepositorio extends JpaRepository<Abonado, Integer> {

    // Buscar abonado por matrícula y comprobar que esté vigente
    @Query("SELECT a FROM Abonado a " +
            "WHERE a.matricula = :matricula " +
            "AND a.fechaIni <= :fecha " +
            "AND a.fechaFin >= :fecha")
    Optional<Abonado> buscarAbonadoVigente(
            @Param("matricula") String matricula,
            @Param("fecha") LocalDate fecha
    );
}
