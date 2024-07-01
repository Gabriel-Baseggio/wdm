package net.weg.wdm.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private Usuario usuario;
    private List<Dispositivo> dispositivos;
    private StatusReserva status;
    private Ambiente ambiente;
    private Turma turma;
    private String comentario;
}
