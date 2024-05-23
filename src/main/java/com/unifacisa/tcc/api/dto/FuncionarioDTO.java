package com.unifacisa.tcc.api.dto;

import com.unifacisa.tcc.persistence.entity.pessoa.PessoaCadastro;
import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.CARGO_FUNCIONARIO;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
public class FuncionarioDTO extends PessoaCadastro {

    private Integer matricula;
    private CARGO_FUNCIONARIO cargoFuncionario;
    private BigDecimal bonus;
    private BigDecimal salario;
    private LocalDate dataAdmissao;

    public FuncionarioDTO(int matricula, CARGO_FUNCIONARIO cargoFuncionario, String nome, String enderecoEmailColaborador,
                          String telefone, BigDecimal bonus, BigDecimal salario, LocalDate dataAdmissao) {
    }
}
