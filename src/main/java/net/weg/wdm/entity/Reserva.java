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
    @JoinColumn(nullable = false)
    private Usuario solicitante;

    @ManyToOne
    @JoinColumn(nullable = false)
    private SolicitacaoReserva solicitacao;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<DispositivoReservado> dispositivosReservados;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Periodo periodo;

    @Column(nullable = false)
    private LocalDate dia;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ambiente ambiente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Turma turma;

    private String comentario;

}
