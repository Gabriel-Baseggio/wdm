package net.weg.wdm.service.implementation;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import net.weg.wdm.entity.*;
import net.weg.wdm.repository.SolicitacaoReservaRepository;
import net.weg.wdm.service.interfaces.SolicitacaoReservaServiceInt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInt {

    private final SolicitacaoReservaRepository repository;
    private final DispositivoServiceImpl dispositivoService;

    @Override
    public List<SolicitacaoReservaResponseDTO> buscarTodasSolicitacoes() {
        List<SolicitacaoReserva> solicitacoes = repository.findAll();
        List<SolicitacaoReservaResponseDTO> response = solicitacoes.stream().map(SolicitacaoReserva::paraDTO).toList();
        return response;
    }

    @Override
    public Page<SolicitacaoResponseDTO> buscarTodasSolicitacoesPage(Pageable pageable) {
        Page<SolicitacaoReserva> solicitacoes = repository.findAll(pageable);
        return solicitacoes.map(SolicitacaoReserva::paraOutraDTO);
    }

    @Override
    public SolicitacaoReservaResponseDTO buscarSolicitacao(Long id) {
        return repository.findById(id).get().paraDTO();
    }

    @Override
    public SolicitacaoReservaResponseDTO criarSolicitacaoReserva(SolicitacaoReservaRequestPostDTO reservaDTO) {

        Map<TipoDispositivo, List<Dispositivo>> dispositivos = dispositivoService.
                buscarDispositivosPorIdSeparadosPorTipo(reservaDTO.idDispositivos());

        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva(reservaDTO, dispositivos);

        return repository.save(solicitacaoReserva).paraDTO();
    }

}
