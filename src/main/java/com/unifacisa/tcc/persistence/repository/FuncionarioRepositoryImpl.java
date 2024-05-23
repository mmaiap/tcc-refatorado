package com.unifacisa.tcc.persistence.repository;

import com.unifacisa.tcc.api.dto.FuncionarioDTO;
import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.CARGO_FUNCIONARIO;
import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.Funcionario;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

@Repository
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private Connection connection;

    public FuncionarioRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    public void close() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public Funcionario inserirFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionarios (matricula, cargo_funcionario, nome, " +
                "email, telefone, bonus, salario, data_admissao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, funcionario.getMatricula());
            statement.setString(2, funcionario.getCargoFuncionario().toString());
            statement.setString(3, funcionario.getNome());
            statement.setString(4, funcionario.getEmail());
            statement.setString(5, funcionario.getTelefone());
            statement.setBigDecimal(6, funcionario.getBonus());
            statement.setBigDecimal(7, funcionario.getSalario());
            statement.setDate(8, Date.valueOf(funcionario.getDataAdmissao()));
            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    funcionario.setMatricula(id);
                    return funcionario;
                } else {
                    throw new SQLException("Falha ao obter o ID do funcionário após a inserção.");
                }
            }
        }
    }

    public Optional<FuncionarioDTO> obterFuncionarioPorId(int matricula) throws SQLException {
        String sql = "SELECT * FROM funcionarios WHERE matricula = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, matricula);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    CARGO_FUNCIONARIO cargoFuncionario = CARGO_FUNCIONARIO.valueOf(resultSet.getString("cargo_funcionario"));
                    String nome = resultSet.getString("nome");
                    String enderecoEmailColaborador = resultSet.getString("email");
                    String telefone = resultSet.getString("telefone");
                    BigDecimal bonus = resultSet.getBigDecimal("bonus");
                    BigDecimal salario = resultSet.getBigDecimal("salario");
                    LocalDate dataAdmissao = resultSet.getDate("data_admissao").toLocalDate();

                    return Optional.of(new FuncionarioDTO(matricula, cargoFuncionario, nome, enderecoEmailColaborador, telefone, bonus, salario, dataAdmissao));
                } else {
                    return Optional.empty();
                }
            }
        }
    }

    public void atualizarFuncionario(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionarios SET cargo_funcionario = ?, nome = ?, email = ?, telefone = ?, bonus = ?, salario = ?, data_admissao = ? WHERE matricula = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, funcionario.getCargoFuncionario().toString());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getEmail());
            statement.setString(4, funcionario.getTelefone());
            statement.setBigDecimal(5, funcionario.getBonus());
            statement.setBigDecimal(6, funcionario.getSalario());
            statement.setDate(7, Date.valueOf(funcionario.getDataAdmissao()));
            statement.setInt(8, funcionario.getMatricula());
            statement.executeUpdate();
        }
    }
}
