package net.weg.wdm.controller.dto.solicitacao;

import net.weg.wdm.controller.dto.reserva.ReservaResponseDTO;
import net.weg.wdm.entity.*;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoReservaResponseDTO(Long id, List<ReservaResponseDTO> reservas) {
}
