package net.weg.wdm.controller.dto.reserva;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class SolicitacaoReservaRequestPostDTO {
    private Long idUsuario;
    private Long idTurma;
    private List<Long> idDispositivos;
    private List<PeriodoReservaRequestPostDTO> periodos;
    private LocalDate inicio;
    private LocalDate fim;
}
