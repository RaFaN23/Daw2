package es.safareyes.parkingapp.Modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets",schema = "parkingapp")
@Getter @Setter
@NoArgsConstructor
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "matricula",nullable = false)
    private String Matricula;

    @Column(name = "hora_entrada")
    private LocalDateTime Hora_Entrada;

    @Column(name = "hora_salida")
    private LocalDateTime Hora_Salida;

    @Column(name = "estado",nullable = false)
    private String Estado;

    @Column(name = "minutos",nullable = false)
    private Integer Minutos;

    @Column(name = "descuento",nullable = false)
    private BigDecimal Descuento;

    @Column(name = "importe_descuento",nullable = false)
    private BigDecimal Importe_Descuento;

    @Column(name = "importe",nullable = false)
    private BigDecimal Importe;

    @Column(name = "numero_Plaza",nullable = false)
    private Integer Numero_plaza;

    @Column(name = "id_tarifa",nullable = false)
    private Integer Id_tarifa;

    @Column(name = "id_abonado",nullable = false)
    private Integer Id_abonado;

    @Column(name = "id_promocion",nullable = false)
    private Integer Id_promocion;



}
