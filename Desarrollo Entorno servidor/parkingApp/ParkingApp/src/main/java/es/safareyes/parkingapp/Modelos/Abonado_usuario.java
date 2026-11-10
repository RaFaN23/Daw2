package es.safareyes.parkingapp.Modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abonado_usuario", schema = "parkingapp")
@Getter
@Setter
@NoArgsConstructor
public class Abonado_usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_abonado")
    private Integer idAbonado;

    @Column(name = "id_usuario")
    private Integer idUsuario;
}