package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Usuario usuario;
    private List<Dispositivo> dispositivos;

    @Column(nullable = false)
    private StatusReserva status;
    private Ambiente ambiente;
    private Turma turma;
    private String comentario;
}
