package es.safareyes.parkingapp.Modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abonado_usuario",schema = "parkingapp")
@Setter @Getter
@NoArgsConstructor
public class Abonado_usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "id_abonado")
    private Integer Id_abonado;

    @Column(name = "id_usuario")
    private Integer Id_usuario;
}
