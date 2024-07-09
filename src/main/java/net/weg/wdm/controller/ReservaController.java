package net.weg.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import net.weg.wdm.entity.SolicitacaoReserva;
import net.weg.wdm.service.implementation.SolicitacaoReservaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reserva")
@AllArgsConstructor
public class ReservaController {

    private SolicitacaoReservaServiceImpl solicitacaoReservaService;

    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroReserva(@RequestBody ReservaRequestPostDTO reservaDTO){
        return new ResponseEntity<>(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO), HttpStatus.OK);
    }

}