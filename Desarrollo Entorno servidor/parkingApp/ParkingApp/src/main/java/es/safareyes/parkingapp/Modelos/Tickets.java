package es.safareyes.parkingapp.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets", schema = "parkingapp")
@Getter
@Setter
@NoArgsConstructor
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "hora_entrada")
    private LocalDateTime horaEntrada;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "minutos", nullable = false)
    private Integer minutos;

    @Column(name = "descuento", nullable = false)
    private BigDecimal descuento;

    @Column(name = "importe_descuento", nullable = false)
    private BigDecimal importeDescuento;

    @Column(name = "importe", nullable = false)
    private BigDecimal importe;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "numero_plaza",
            referencedColumnName = "numero",
            nullable = false
    )
    private Plaza plaza;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_tarifa",
            nullable = false
    )
    private Tarifa tarifa;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_abonado",
            nullable = false
    )
    private Abonado abonado;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "id_promocion",
            nullable = false
    )
    private Promocion promocion;
}