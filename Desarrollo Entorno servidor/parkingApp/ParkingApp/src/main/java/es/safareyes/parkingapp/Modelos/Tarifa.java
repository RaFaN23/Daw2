package es.safareyes.parkingapp.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tarifa", schema = "parkingapp")
@Getter
@Setter
@NoArgsConstructor
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "min_cortesia", nullable = false)
    private Integer minCortesia;

    @Column(name = "precio_por_min", nullable = false)
    private BigDecimal precioPorMin;

    @Column(name = "tope_maximo", nullable = false) 
    private BigDecimal topeMaximo;

    @Column(name = "fecha_aplica", nullable = false)
    private LocalDate fechaAplica;

    @OneToMany(mappedBy = "tarifa", fetch = FetchType.LAZY)
    private List<Tickets> tickets;
}