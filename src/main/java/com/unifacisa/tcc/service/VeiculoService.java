package com.unifacisa.tcc.service;

import com.unifacisa.tcc.persistence.entity.veiculos.*;
import com.unifacisa.tcc.persistence.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;

@Service
public class VeiculoService implements VeiculoCombustaoCalculos {

    @Autowired
    private VeiculoRepository repository;

    @Override
    public BigDecimal getValorTanqueCheio(BigDecimal valorCombustivelDia, VeiculoCombustao veiculoCombustao) {
        return valorCombustivelDia.multiply(veiculoCombustao.capacidadeTanque);
    }

    public Carro getCarro(Integer id) throws SQLException {
        return repository.obterCarroPorId(id).get();
    }

    public Carro inserirCarro(Carro carro) throws SQLException {
        return repository.inserirCarro(carro);
    }

    public CarroEletrico getCarroEletrico(Integer id) throws SQLException {
        return repository.obterCarroEletricoPorId(id).get();
    }

    public CarroEletrico inserirCarroEletrico(CarroEletrico carroEletrico) throws SQLException {
        return repository.inserirCarroEletrico(carroEletrico);
    }

    public Moto getMoto(Integer id) throws SQLException {
        return repository.obterMotoPorId(id).get();
    }

    public Moto inserirMoto(Moto moto) throws SQLException {
        return repository.inserirMoto(moto);
    }
}
