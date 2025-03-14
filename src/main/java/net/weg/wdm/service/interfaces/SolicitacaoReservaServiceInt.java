package net.weg.wdm.service.interfaces;

import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import net.weg.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolicitacaoReservaServiceInt {

    List<SolicitacaoReservaResponseDTO> buscarTodasSolicitacoes();

    Page<SolicitacaoResponseDTO> buscarTodasSolicitacoesPage(Pageable pageable);

    SolicitacaoReservaResponseDTO buscarSolicitacao(Long id);

    SolicitacaoReservaResponseDTO criarSolicitacaoReserva(SolicitacaoReservaRequestPostDTO reservaDTO);
}
