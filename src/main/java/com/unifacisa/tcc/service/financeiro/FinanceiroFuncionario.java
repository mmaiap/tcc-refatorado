package com.unifacisa.tcc.service.financeiro;

import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.CARGO_FUNCIONARIO;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FinanceiroFuncionario {
    BigDecimal calcularBonus(LocalDate dataInicio, BigDecimal salario);

    BigDecimal retornaSalario(CARGO_FUNCIONARIO cargoFuncionario);
}
