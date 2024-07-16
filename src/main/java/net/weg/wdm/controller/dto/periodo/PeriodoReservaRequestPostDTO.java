package net.weg.wdm.controller.dto.periodo;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.weg.wdm.entity.DiaSemana;

public record PeriodoReservaRequestPostDTO(Long idPeriodo, Long idAmbiente, DiaSemana diaSemana) {
}
