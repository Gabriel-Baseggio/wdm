package net.weg.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long numero;

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false, length = 50)
    private String modelo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoDispositivo tipo;

    @OneToMany(mappedBy = "dispositivo")
    @JsonIgnore
    @ToString.Exclude
    private List<DispositivoReservado> reservasDoDispositivo;

    @OneToMany(mappedBy = "dispositivo")
    private List<Manutencao> manutencoes;

    private String descricao;

    private Boolean habilitado = true;

}
