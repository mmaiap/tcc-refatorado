package com.unifacisa.tcc.persistence.entity.pessoa.cliente;

import com.unifacisa.tcc.persistence.entity.pessoa.PessoaCadastro;
import com.unifacisa.tcc.persistence.entity.veiculos.Veiculo;
import lombok.Data;


@Data
public class Cliente extends PessoaCadastro {

    private Integer id;
    private Double saldoEmCompras;
    private Veiculo veiculo;

    public Cliente(int id, String nome, String emailCliente, String telefone, Double saldoEmCompras) {
        this.id = id;
        this.nome = nome;
        this.email = emailCliente;
        this.telefone = telefone;
        this.saldoEmCompras = saldoEmCompras;
    }
}
