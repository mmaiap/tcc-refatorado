package com.unifacisa.tcc.service.financeiro;

import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.CARGO_FUNCIONARIO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class FinanceiroFuncionarioFactory implements AbstractFinanceiroFactory {

    private static final Map<CARGO_FUNCIONARIO, FinanceiroFuncionario> services = new HashMap<>();

    public FinanceiroFuncionarioFactory() {
    }

    static {
        services.put(CARGO_FUNCIONARIO.VENDEDOR, new FinanceiroVendedor());
        services.put(CARGO_FUNCIONARIO.GERENTE, new FinanceiroGerente());
        services.put(CARGO_FUNCIONARIO.SEGURANCA, new FinanceiroSeguranca());
    }

    public FinanceiroFuncionario create(CARGO_FUNCIONARIO cargo) {
        FinanceiroFuncionario service = services.get(cargo);
        if (service == null) {
            throw new IllegalArgumentException("Nenhuma service encontrada para o cargo: " + cargo);
        }
        return service;
    }
}


