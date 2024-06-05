package com.unifacisa.tcc.service.financeiro;

import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.CARGO_FUNCIONARIO;

public interface FinanceiroFactory {

    FinanceiroFuncionario create(CARGO_FUNCIONARIO cargoFuncionario);

}
