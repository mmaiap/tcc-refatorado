package com.unifacisa.tcc.persistence.repository;

import com.unifacisa.tcc.persistence.entity.pessoa.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ClienteRepositoryImpl implements ClienteRepository{

    private Connection connection;

    @Autowired
    public ClienteRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Optional<Cliente> obterClientePorId(int id) throws SQLException {
        String sql = "SELECT * FROM clientes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String nome = resultSet.getString("nome");
                    String emailCliente = resultSet.getString("email");
                    String telefone = resultSet.getString("telefone");
                    Double saldoEmCompras = resultSet.getDouble("saldoEmCompras");

                    return Optional.of(new Cliente(id, nome, emailCliente, telefone,
                            saldoEmCompras));
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, email = ?, telefone = ?, saldo_em_compras = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefone());
            statement.setDouble(4, cliente.getSaldoEmCompras());
            statement.setInt(5, cliente.getId());
            statement.executeUpdate();
        }
    }

    public Cliente inserirCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, email, veiculo, telefone, saldo_em_compras) VALUES (?,?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getEmail());
            statement.setInt(3, cliente.getVeiculo().getId());
            statement.setString(4, cliente.getTelefone());
            statement.setDouble(5, cliente.getSaldoEmCompras());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    cliente.setId(id);
                    return cliente;
                } else {
                    throw new SQLException("Falha ao obter o ID do cliente após a inserção.");
                }
            }
        }
    }

}
