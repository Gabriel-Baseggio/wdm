package net.weg.wdm.repository;

import net.weg.wdm.entity.Reserva;
import net.weg.wdm.entity.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Long findAllByAmbiente_IdAndStatusOrderByDiaDesc(Long idTurma, StatusReserva statusReserva);

}
