package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.periodo.PeriodoResponseDTO;
import net.weg.wdm.controller.dto.reserva.ReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SolicitacaoReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario solicitante;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "solicitacao_id", nullable = false)
    private List<Reserva> reservas;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Turma turma;

    private LocalDate inicio;

    private LocalDate fim;

    public SolicitacaoReserva(SolicitacaoReservaRequestPostDTO dto, Map<TipoDispositivo, List<Dispositivo>> dispositivos ) {
        Set<TipoDispositivo> tipos = dispositivos.keySet();

        this.solicitante = new Usuario(dto.idUsuario());
        this.reservas = new ArrayList<>();
        this.turma = new Turma(dto.idTurma());
        this.inicio = dto.inicio();
        this.fim = dto.fim();

        LocalDate data = dto.inicio();
        do {
            for (PeriodoReservaRequestPostDTO periodoDTO : dto.periodos()) {
                if (periodoDTO.diaSemana().ordinal() == data.getDayOfWeek().ordinal()) {
                    for (TipoDispositivo tipo : tipos) {
                        List<DispositivoReservado> dispositivosReservados = dispositivos.get(tipo)
                                .stream().map(DispositivoReservado::new).toList();

                        Reserva reserva = new Reserva(periodoDTO, data, dispositivosReservados);
                        reservas.add(reserva);
                    }
                }
            }
            data = data.plusDays(1);
        } while (data.isBefore(dto.fim().plusDays(1)));
    }

    public SolicitacaoReservaResponseDTO paraDTO() {
        List<ReservaResponseDTO> reservas = this.reservas.stream().map(Reserva::paraDTO).toList();
        return new SolicitacaoReservaResponseDTO(this.id, reservas);
    }

    public SolicitacaoResponseDTO paraOutraDTO() {
        Reserva primeiraReserva = this.reservas.get(0);

        Set<Dispositivo> dispositivos = new HashSet<>();
        List<PeriodoResponseDTO> periodos = new ArrayList<>();
        LocalDate inicio = primeiraReserva.getDia();
        LocalDate fim = primeiraReserva.getDia();

        for (Reserva reserva : reservas) {
            reserva.getDispositivosReservados().forEach(dispositivoReservado -> {
                dispositivos.add(dispositivoReservado.getDispositivo());
            });

            PeriodoResponseDTO periodo = new PeriodoResponseDTO(reserva.getPeriodo(), reserva.getAmbiente(),
                    DiaSemana.traduzirDiaDaSemana(reserva.getDia().getDayOfWeek()));
            periodos.add(periodo);

            if (inicio.isAfter(reserva.getDia())) {
                inicio = reserva.getDia();
            }
            if (fim.isBefore(reserva.getDia())) {
                fim = reserva.getDia();
            }
        }

        return new SolicitacaoResponseDTO(this.solicitante, this.turma, new ArrayList<>(dispositivos), periodos, inicio, fim);
    }

}
