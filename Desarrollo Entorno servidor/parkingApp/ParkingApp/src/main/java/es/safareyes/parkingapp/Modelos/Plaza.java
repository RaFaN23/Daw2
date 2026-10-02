package es.safareyes.parkingapp.Modelos;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "plaza",schema = "parkingapp")
@Setter @Getter
@NoArgsConstructor
public class Plaza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name = "estado")
    private String Estado;

    @Column(name = "numero")
    private Integer Numero;

    @Column(name = "planta")
    private Integer Planta;

    @Column(name = "tipo")
    private String Tipo;
}
