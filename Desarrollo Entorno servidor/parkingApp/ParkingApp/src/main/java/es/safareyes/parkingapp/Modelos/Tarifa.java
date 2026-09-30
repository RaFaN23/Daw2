package es.safareyes.parkingapp.Modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tarifa",schema = "parkingapp")
@Getter @Setter
@NoArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "min_cortesia",nullable = false)
    private Integer Min_cortesia;

    @Column(name = "precio_por_min")
    private BigDecimal Precio_Por_Min;

    @Column(name = "tope_maximo")
    private BigDecimal Tope_maximo;

    @Column(name = "fecha_aplica")
    private LocalDate Fecha_aplica;

}
