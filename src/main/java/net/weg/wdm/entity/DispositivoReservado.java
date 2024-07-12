package net.weg.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class DispositivoReservado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NonNull
    @JoinColumn(nullable = false)
    private Dispositivo dispositivo;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NonNull
    @ToString.Exclude
    @JsonIgnore
    private Reserva reserva;

    private LocalDateTime retirada;

    private LocalDateTime devolucao;

}
