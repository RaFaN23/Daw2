package es.safareyes.parkingapp.Modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuario",schema = "parkingapp")
@Getter @Setter
@NoArgsConstructor
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre",nullable = false)
    private String Nombre;

    @Column(name = "contraseña",nullable = false)
    private String Contrasenya;

}
