package es.safareyes.parkingapp.Modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "promocion",schema = "parkingapp")
@Getter @Setter
@NoArgsConstructor
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "nombre")
    private String Nombre;

    @Column(name = "tipo")
    private  String Tipo;

    @Column(name = "min_descuento")
    private Integer Min_descuento;
}
