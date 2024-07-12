package net.weg.wdm.service.implementation;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.reserva.PeriodoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.entity.*;
import net.weg.wdm.repository.SolicitacaoReservaRepository;
import net.weg.wdm.repository.UsuarioRepository;
import net.weg.wdm.service.interfaces.SolicitacaoReservaServiceInt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt {

    private final SolicitacaoReservaRepository repository;
    private final UsuarioRepository usuarioRepository;
    private final DispositivoServiceImpl dispositivoService;

    @Override
    public SolicitacaoReserva criarSolicitacaoReserva(ReservaRequestPostDTO reservaDTO) {
        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva();

        Map<TipoDispositivo, List<Dispositivo>> dispositivos = dispositivoService.
                buscarDispositivosPorIdSeparadosPorTipo(reservaDTO.getIdDispositivos());

        List<Reserva> reservas = new ArrayList<>();

        Set<TipoDispositivo> tipos = dispositivos.keySet();

        LocalDate data = reservaDTO.getInicio();
        do {
            for (PeriodoReservaRequestPostDTO periodoDTO : reservaDTO.getPeriodos()) {
                if (periodoDTO.getDiaSemana().ordinal() == data.getDayOfWeek().ordinal()) {
                    for (TipoDispositivo tipo : tipos) {
                        reservas.add(criarReserva(reservaDTO, periodoDTO, data, tipo, dispositivos));
                    }
                }
            }
            data = data.plusDays(1);
        } while (data.isBefore(reservaDTO.getFim().plusDays(1)));

        solicitacaoReserva.setReservas(reservas);

        return repository.save(solicitacaoReserva);
    }

    private Reserva criarReserva(ReservaRequestPostDTO reservaDTO, PeriodoReservaRequestPostDTO periodoDTO, LocalDate data, TipoDispositivo tipo, Map<TipoDispositivo, List<Dispositivo>> dispositivos) {
        Reserva reserva = new Reserva();
        reserva.setSolicitante(usuarioRepository.findById(reservaDTO.getIdUsuario()).orElse(null));
//        reserva.setSolicitante(new Usuario(reservaDTO.getIdUsuario()));
        reserva.setPeriodo(new Periodo(periodoDTO.getIdPeriodo()));
        reserva.setAmbiente(new Ambiente(periodoDTO.getIdAmbiente()));
        reserva.setTurma(new Turma(reservaDTO.getIdTurma()));
        reserva.setDispositivosReservados(dispositivos.get(tipo).stream()
                .map(DispositivoReservado::new).toList());
        return reserva;
    }

}
