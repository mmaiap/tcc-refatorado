package com.unifacisa.tcc.service.financeiro;

import com.unifacisa.tcc.api.dto.FuncionarioDTO;
import com.unifacisa.tcc.persistence.entity.pessoa.cliente.Cliente;
import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.CARGO_FUNCIONARIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
public class FinanceiroService {

    @Autowired
    private FinanceiroFuncionarioFactory factory;

    public BigDecimal calcularDesconto(Cliente cliente) {

        BigDecimal desconto = BigDecimal.valueOf(0);

        if (cliente.getSaldoEmCompras() >= 500) {
            desconto = BigDecimal.valueOf(0.1);
        }else if(cliente.getSaldoEmCompras() <= 5000 && cliente.getSaldoEmCompras() >= 2000){
            desconto = BigDecimal.valueOf(0.2);
        }

        return desconto;
    }

    public String gerarRelatorioFuncionario(FuncionarioDTO funcionario) {
        String relatorio = "Não existe esse colaborador";
        if(!isEmpty(funcionario)){
            relatorio = "Funcionario(a) de matrícula " + funcionario.getNome() + "possui salario " + funcionario.getSalario() + " e teve bonus de " + funcionario.getBonus() +
                    " no mes atual";
        }
        return relatorio;
    }

    public BigDecimal calcularBonusAnual(LocalDate dataInicio,
                                         CARGO_FUNCIONARIO cargoFuncionario, BigDecimal salario) {
        FinanceiroFuncionario service = factory.create(cargoFuncionario);
        return service.calcularBonus(dataInicio, salario);
    }

    public BigDecimal retornaSalarioBase(CARGO_FUNCIONARIO cargoFuncionario){
        FinanceiroFuncionario service = factory.create(cargoFuncionario);
        return service.retornaSalario(cargoFuncionario);
    }
}
