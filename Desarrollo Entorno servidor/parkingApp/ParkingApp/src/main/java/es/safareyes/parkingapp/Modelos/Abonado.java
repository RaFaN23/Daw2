package es.safareyes.parkingapp.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "abonado", schema = "parkingapp")
@Getter
@Setter
@NoArgsConstructor
public class Abonado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "matricula", nullable = false)
    private String matricula;

    @Column(name = "fecha_ini", nullable = false)
    private LocalDate fechaIni;

    @Column(name = "fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "abonado", fetch = FetchType.LAZY)
    private List<Tickets> tickets;

    @ManyToMany(mappedBy = "abonados", fetch = FetchType.LAZY)
    private List<Usuarios> usuarios;
}