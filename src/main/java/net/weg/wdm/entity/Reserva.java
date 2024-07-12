package net.weg.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

//    @ManyToOne
//    @ToString.Exclude
//    @JsonIgnore
//    private SolicitacaoReserva solicitacao;

//    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserva_id")
    private List<DispositivoReservado> dispositivosReservados;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusReserva status = StatusReserva.EM_ABERTO;

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
