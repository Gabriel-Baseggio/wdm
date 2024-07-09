package net.weg.wdm.entity;

import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DiaSemana {

    SEGUNDA("Segunda-feira"),
    TERCA("Terça-feira"),
    QUARTA("Quarta-feira"),
    QUINTA("Quinta-feira"),
    SEXTA("Sexta-feira"),
    SABADO("Sábado"),
    DOMINGO("Domingo");

    private final String NOME;

}
