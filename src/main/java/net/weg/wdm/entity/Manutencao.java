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
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario solicitante;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Dispositivo dispositivo;

    @Column(nullable = false)
    private String descricao;

    private String feedback;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusManutencao status;

}
