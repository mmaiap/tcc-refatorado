package com.unifacisa.tcc.persistence.repository;

import com.unifacisa.tcc.persistence.entity.veiculos.Carro;
import com.unifacisa.tcc.persistence.entity.veiculos.CarroEletrico;
import com.unifacisa.tcc.persistence.entity.veiculos.Moto;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class VeiculoRepositoryImpl implements VeiculoRepository{

    private Connection connection;

    @Autowired
    public VeiculoRepositoryImpl(Connection connection){
        this.connection = connection;
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Carro inserirCarro(Carro carro) throws SQLException {
        String sql = "INSERT INTO carros (nome, modelo, ano, preco, capacidadeTanque) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, carro.getNome());
            statement.setString(2, carro.getModelo());
            statement.setInt(3, carro.getAno());
            statement.setBigDecimal(4, carro.getPreco());
            statement.setBigDecimal(5, carro.getCapacidadeTanque());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    carro.setId(id);
                    return carro;
                } else {
                    throw new SQLException("Falha ao obter o ID do carro após a inserção.");
                }
            }
        }
    }

    public CarroEletrico inserirCarroEletrico(CarroEletrico carroEletrico) throws SQLException {
        String sql = "INSERT INTO carros_eletricos (nome, modelo, ano, preco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, carroEletrico.getNome());
            statement.setString(2, carroEletrico.getModelo());
            statement.setInt(3, carroEletrico.getAno());
            statement.setBigDecimal(4, carroEletrico.getPreco());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    carroEletrico.setId(id);
                    return carroEletrico;
                } else {
                    throw new SQLException("Falha ao obter o ID do Carro Eletrico após a inserção.");
                }
            }
        }
    }

    public Moto inserirMoto(Moto moto) throws SQLException {
        String sql = "INSERT INTO motos (nome, modelo, ano, preco, capacidadeTanque) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, moto.getNome());
            statement.setString(2, moto.getModelo());
            statement.setInt(3, moto.getAno());
            statement.setBigDecimal(4, moto.getPreco());
            statement.setBigDecimal(5, moto.getCapacidadeTanque());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    moto.setId(id);
                    return moto;
                } else {
                    throw new SQLException("Falha ao obter o ID da moto após a inserção.");
                }
            }
        }
    }

    public Optional<Carro> obterCarroPorId(int id) throws SQLException {
        String sql = "SELECT * FROM carros WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String modelo = resultSet.getString("modelo");
                    Integer ano = resultSet.getInt("ano");
                    BigDecimal preco = resultSet.getBigDecimal("preco");
                    BigDecimal capacidadeTanque = resultSet.getBigDecimal("capacidadeTanque");

                    return Optional.of(new Carro(id,nome, modelo, ano, preco, capacidadeTanque));
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public Optional<CarroEletrico> obterCarroEletricoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM carros_eletricos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String modelo = resultSet.getString("modelo");
                    Integer ano = resultSet.getInt("ano");
                    BigDecimal preco = resultSet.getBigDecimal("preco");

                    return Optional.of(new CarroEletrico(id,nome, modelo, ano, preco));
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public Optional<Moto> obterMotoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM motos WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String modelo = resultSet.getString("modelo");
                    Integer ano = resultSet.getInt("ano");
                    BigDecimal preco = resultSet.getBigDecimal("preco");
                    BigDecimal capacidadeTanque = resultSet.getBigDecimal("capacidadeTanque");

                    return Optional.of(new Moto(id,nome, modelo, ano, preco, capacidadeTanque));
                } else {
                    return Optional.empty();
                }
            }
        }
    }
}
