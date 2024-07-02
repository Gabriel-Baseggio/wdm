package net.weg.wdm.entity;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DiaSemana {

    DOMINGO("Domingo"),
    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado");

    private final String NOME;

}
