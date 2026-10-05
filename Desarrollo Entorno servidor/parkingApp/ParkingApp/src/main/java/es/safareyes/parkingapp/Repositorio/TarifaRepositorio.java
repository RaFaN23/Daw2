package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Tarifa;
import es.safareyes.parkingapp.dtos.tarifasVigentes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarifaRepositorio extends JpaRepository<Tarifa,Integer> {
    @Query(
            nativeQuery = true,
            value = "SELECT t.id AS id_tarifa, " +
                    "tk.matricula, " +
                    "u.nombre AS nombre_usuario " +
                    "FROM parkingapp.tarifa t " +
                    "JOIN parkingapp.tickets tk ON tk.id_tarifa = t.id " +
                    "JOIN parkingapp.abonado a ON a.id = tk.id_abonado " +
                    "JOIN parkingapp.abonado_usuario au ON au.id_abonado = a.id " +
                    "JOIN parkingapp.usuario u ON u.id = au.id_usuario " +
                    "WHERE t.fecha_aplica >= CURRENT_DATE " +
                    "ORDER BY t.fecha_aplica DESC"
    )
    List<tarifasVigentes> tarifasVigentes();
}
