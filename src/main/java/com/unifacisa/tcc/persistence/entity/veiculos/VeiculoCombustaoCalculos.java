package com.unifacisa.tcc.persistence.entity.veiculos;

import java.math.BigDecimal;

public interface VeiculoCombustaoCalculos {

    public BigDecimal getValorTanqueCheio(BigDecimal valorCombustivelDia, VeiculoCombustao veiculoCombustao);
}
