package net.weg.wdm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoUsuario {
    USUARIO("Usuário"),
    ADMINISTRADOR("Administrador");

    private final String NOME;

}
