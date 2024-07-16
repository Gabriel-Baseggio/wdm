package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.reserva.ReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;

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

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Usuario solicitante;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserva_id", nullable = false)
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

//    @ManyToOne
//    @JoinColumn(nullable = false)
//    private Turma turma;

    private String comentario;

    public Reserva(PeriodoReservaRequestPostDTO periodoDTO, LocalDate data, List<DispositivoReservado> dispositivos) {
        this.dia = data;

        this.periodo = new Periodo(periodoDTO.idPeriodo());
        this.ambiente = new Ambiente(periodoDTO.idAmbiente());
        this.dispositivosReservados = dispositivos;
    }

    public ReservaResponseDTO paraDTO() {
        return new ReservaResponseDTO(this.numero, this.dispositivosReservados, this.status.getNOME(), this.ambiente, this.periodo, this.dia, this.comentario);
    }

}
