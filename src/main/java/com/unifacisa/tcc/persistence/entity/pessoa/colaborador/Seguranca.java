package com.unifacisa.tcc.persistence.entity.pessoa.colaborador;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class Seguranca extends Funcionario{

    private Integer matricula;
    private CARGO_FUNCIONARIO cargoFuncionario;
    private BigDecimal bonus;
    private BigDecimal salario;
    private LocalDate dataAdmissao;

}
