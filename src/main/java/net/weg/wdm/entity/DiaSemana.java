package net.weg.wdm.entity;

import lombok.AllArgsConstructor;

import java.time.DayOfWeek;

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

    public static String traduzirDiaDaSemana(DayOfWeek diaSemanaENG) {
        for (DiaSemana diaSemanaPT : DiaSemana.values()) {
            if (diaSemanaPT.ordinal() == diaSemanaENG.ordinal()) {
                return diaSemanaPT.NOME;
            }
        }
        return null;
    }


}
