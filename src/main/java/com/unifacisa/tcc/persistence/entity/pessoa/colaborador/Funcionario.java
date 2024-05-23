package com.unifacisa.tcc.persistence.entity.pessoa.colaborador;

import com.unifacisa.tcc.persistence.entity.pessoa.PessoaCadastro;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public abstract class Funcionario extends PessoaCadastro {

    private Integer matricula;
    private CARGO_FUNCIONARIO cargoFuncionario;
    private BigDecimal bonus;
    private BigDecimal salario;
    private LocalDate dataAdmissao;

}
