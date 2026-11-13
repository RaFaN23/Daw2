package es.safareyes.parkingapp.Repositorio;

import es.safareyes.parkingapp.Modelos.Descuento;
import es.safareyes.parkingapp.dtos.descuentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescuentoRepositorio extends JpaRepository<Descuento, Integer> {

    // Obtener los descuentos aplicados a un ticket
    @Query("SELECT new es.safareyes.parkingapp.dtos.descuentoDTO(" +
            "d.promocion.nombre, d.promocion.tipo, d.minutosAplicados) " +
            "FROM Descuento d " +
            "WHERE d.ticket.id = :idTicket " +
            "ORDER BY d.fechaAplicacion")
    List<descuentoDTO> buscarDescuentosPorTicket(
            @Param("idTicket") Integer idTicket
    );

    // Comprobar si una promoción ya se ha aplicado a un ticket
    boolean existsByTicketIdAndPromocionId(Integer idTicket, Integer idPromocion);

    // Sumar los minutos de descuento aplicados a un ticket
    @Query("SELECT COALESCE(SUM(d.minutosAplicados), 0L) " +
            "FROM Descuento d " +
            "WHERE d.ticket.id = :idTicket")
    Long sumarMinutosDescuento(@Param("idTicket") Integer idTicket);
}