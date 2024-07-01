package net.weg.wdm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusReserva {
    EM_ABERTO("Em Aberto"),
    AGUADANDO_RETIRADA("Aguardando Retirada"),
    AGUARDANDO_DEVOLUCAO("Aguardando Devolução"),
    ATRASADO("Atrasado"),
    CONCLUIDA("Concluída"),
    CANCELADA("Cancelada");

    private final String NOME;

}
