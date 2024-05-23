package com.unifacisa.tcc.persistence.repository;

import com.unifacisa.tcc.api.dto.FuncionarioDTO;
import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.Funcionario;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public interface FuncionarioRepository {

    public Funcionario inserirFuncionario(Funcionario funcionario) throws SQLException;

    public Optional<FuncionarioDTO> obterFuncionarioPorId(int matricula) throws SQLException;

    public void atualizarFuncionario(Funcionario funcionario) throws SQLException;
}
