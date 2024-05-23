package com.unifacisa.tcc.persistence.entity.veiculos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class Veiculo {
    public Integer id;
    public String nome;
    public String modelo;
    public Integer ano;
    public BigDecimal preco;
}
