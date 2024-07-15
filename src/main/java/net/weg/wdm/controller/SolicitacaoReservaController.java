package net.weg.wdm.controller;

import lombok.AllArgsConstructor;
import net.weg.wdm.controller.dto.reserva.SolicitacaoReservaRequestPostDTO;
import net.weg.wdm.entity.SolicitacaoReserva;
import net.weg.wdm.service.implementation.SolicitacaoReservaServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitacao")
@AllArgsConstructor
public class SolicitacaoReservaController {

    private SolicitacaoReservaServiceImpl solicitacaoReservaService;

    @GetMapping
    public ResponseEntity<List<SolicitacaoReserva>> buscarTodasSolicitacoes(){
        return new ResponseEntity<>(solicitacaoReservaService.buscarTodasSolicitacoes(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<SolicitacaoReserva>> buscarTodasSolicitacoesPage(Pageable pageable){
        return new ResponseEntity<>(solicitacaoReservaService.buscarTodasSolicitacoesPage(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoReserva> buscarSolicitacao(@PathVariable Long id){
        return new ResponseEntity<>(solicitacaoReservaService.buscarSolicitacao(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroSolicitacao(@RequestBody SolicitacaoReservaRequestPostDTO reservaDTO){
        return new ResponseEntity<>(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO), HttpStatus.OK);
    }

}