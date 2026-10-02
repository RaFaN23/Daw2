package es.safareyes.parkingapp.Modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "abonado",schema = "parkingapp")
@Setter @Getter
@NoArgsConstructor
public class Abonado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "matricula")
    private String Matricula;

    @Column(name = "fecha_ini")
    private LocalDate Fecha_ini;

    @Column(name = "fecha_fin")
    private LocalDate Fecha_fin;

}
