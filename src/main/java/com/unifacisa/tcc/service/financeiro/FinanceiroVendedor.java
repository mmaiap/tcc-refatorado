package com.unifacisa.tcc.service.financeiro;

import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.CARGO_FUNCIONARIO;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.unifacisa.tcc.utils.Utils.calcularAnosTrabalhados;

public class FinanceiroVendedor implements FinanceiroFuncionario {

    @Override
    public BigDecimal calcularBonus(LocalDate dataInicio, BigDecimal salario) {
        long anosTrabalhados = calcularAnosTrabalhados(dataInicio);
        if (anosTrabalhados >= 10) {
            return salario.multiply(BigDecimal.valueOf(0.15));
        } else if (anosTrabalhados >= 5) {
            return salario.multiply(BigDecimal.valueOf(0.12));
        }
        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal retornaSalario(CARGO_FUNCIONARIO cargoFuncionario) {
        return BigDecimal.valueOf(2000);
    }
}


