package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    @ManyToOne
    @Column(nullable = false)
    private Usuario solicitante;

    @ManyToOne
    @Column(nullable = false)
    private SolicitacaoReserva solicitacao;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<DispositivoReservado> dispositivosReservados;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @ManyToOne
    @Column(nullable = false)
    private Periodo periodo;

    @Column(nullable = false)
    private LocalDate dia;

    @ManyToOne
    private Ambiente ambiente;

    @ManyToOne
    private Turma turma;

    private String comentario;

}
