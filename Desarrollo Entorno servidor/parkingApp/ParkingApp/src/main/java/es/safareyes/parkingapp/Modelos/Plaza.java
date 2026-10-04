package es.safareyes.parkingapp.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "plaza", schema = "parkingapp")
@Getter
@Setter
@NoArgsConstructor
public class Plaza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "numero", nullable = false, unique = true)
    private Integer numero;

    @Column(name = "planta", nullable = false)
    private Integer planta;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "plaza", fetch = FetchType.LAZY)
    private List<Tickets> tickets;
}