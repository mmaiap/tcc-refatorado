package com.unifacisa.tcc.persistence.entity.veiculos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public abstract class VeiculoCombustao extends Veiculo {

    public BigDecimal capacidadeTanque;

}
