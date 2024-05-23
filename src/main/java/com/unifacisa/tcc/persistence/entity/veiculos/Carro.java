package com.unifacisa.tcc.persistence.entity.veiculos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Carro extends VeiculoCombustao {

    public Integer id;
    public String nome;
    public String modelo;
    public Integer ano;
    public BigDecimal preco;

    public Carro(Integer id, String nome, String modelo, Integer ano, BigDecimal preco, BigDecimal capacidadeTanque) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.capacidadeTanque = capacidadeTanque;
    }
}
