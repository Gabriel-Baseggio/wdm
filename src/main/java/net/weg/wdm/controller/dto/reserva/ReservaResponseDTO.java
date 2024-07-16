package net.weg.wdm.controller.dto.reserva;

import net.weg.wdm.entity.Ambiente;
import net.weg.wdm.entity.DispositivoReservado;
import net.weg.wdm.entity.Periodo;
import net.weg.wdm.entity.Turma;

import java.time.LocalDate;
import java.util.List;

public record ReservaResponseDTO(Long numero, List<DispositivoReservado> dispositivosReservados, String statusReserva, Ambiente ambiente, Periodo periodo, LocalDate dia, String comentario) {
}
