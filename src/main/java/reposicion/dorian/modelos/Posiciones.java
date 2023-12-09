package reposicion.dorian.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posiciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Posiciones {

    @Id
    @Column(name = "codigoequipo")
    private int codigoEquipo;

    private int empates;

    private int ganados;

    private int perdidos;

    @Column(name = "golesfavor")
    private int golesFavor;

    @Column(name = "golescontra")
    private int golesContra;

    private int puntos;

}
