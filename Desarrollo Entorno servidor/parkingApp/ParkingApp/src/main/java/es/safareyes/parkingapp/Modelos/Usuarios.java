package es.safareyes.parkingapp.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "usuario", schema = "parkingapp")
@Getter
@Setter
@NoArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "contraseña", nullable = false)
    private String contrasenya;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "abonado_usuario",
            schema = "parkingapp",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_abonado")
    )
    private List<Abonado> abonados;
}