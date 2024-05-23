package com.unifacisa.tcc.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Utils {

    public static long calcularAnosTrabalhados(LocalDate dataInicio) {
        LocalDate dataAtual = LocalDate.now();
        return ChronoUnit.YEARS.between(dataInicio, dataAtual);
    }
}
