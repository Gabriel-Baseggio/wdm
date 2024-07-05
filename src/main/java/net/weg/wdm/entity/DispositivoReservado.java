package net.weg.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DispositivoReservado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Dispositivo dispositivo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Reserva reserva;

    private LocalDateTime retirada;

    private LocalDateTime devolucao;

}
