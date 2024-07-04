package net.weg.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.entity.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @PostMapping
    public ResponseEntity<Reserva> cadastroReserva(@RequestBody ReservaRequestPostDTO reservaDTO){
        return new ResponseEntity<>(new Reserva(), HttpStatus.OK);
    }

}
