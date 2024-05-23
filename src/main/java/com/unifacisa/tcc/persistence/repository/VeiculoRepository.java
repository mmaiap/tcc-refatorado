package com.unifacisa.tcc.persistence.repository;

import com.unifacisa.tcc.persistence.entity.veiculos.Carro;
import com.unifacisa.tcc.persistence.entity.veiculos.CarroEletrico;
import com.unifacisa.tcc.persistence.entity.veiculos.Moto;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public interface VeiculoRepository {

    public Carro inserirCarro(Carro carro) throws SQLException;

    public CarroEletrico inserirCarroEletrico(CarroEletrico carroEletrico) throws SQLException;

    public Moto inserirMoto(Moto moto) throws SQLException;

    public Optional<Carro> obterCarroPorId(int id) throws SQLException;

    public Optional<CarroEletrico> obterCarroEletricoPorId(int id) throws SQLException;

    public Optional<Moto> obterMotoPorId(int id) throws SQLException;
}
