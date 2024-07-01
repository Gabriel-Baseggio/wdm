package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, unique = true, length = 200)
    private String email;
    @Column(nullable = false)
    private String senha;
    private Boolean habilitado;
    private List<Reserva> reservas;
    @Column(nullable = false)
    private TipoUsuario tipo;
    private List<GrupoDispositivo> gruposDispositivos;

}
