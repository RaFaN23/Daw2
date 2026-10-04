package es.safareyes.parkingapp.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "promocion", schema = "parkingapp")
@Getter
@Setter
@NoArgsConstructor
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "min_descuento", nullable = false)
    private Integer minDescuento;

    @OneToMany(mappedBy = "promocion", fetch = FetchType.LAZY)
    private List<Tickets> tickets;
}