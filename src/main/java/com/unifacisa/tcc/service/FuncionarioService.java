package com.unifacisa.tcc.service;

import com.unifacisa.tcc.api.dto.FuncionarioDTO;
import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.Funcionario;
import com.unifacisa.tcc.persistence.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class FuncionarioService  {

    @Autowired
    private FuncionarioRepository repository;

    public Funcionario adicionarColaborador(Funcionario funcionario){
        try {
            return repository.inserirFuncionario(funcionario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir colaborador");
        }
    }

    public FuncionarioDTO dadosColaborador(Integer matricula) throws SQLException{
        return repository.obterFuncionarioPorId(matricula).
                orElseThrow(() -> new RuntimeException("Funcionario não encontrado por matrícula"));
    }

    public void atualizarDadosColaborador(Funcionario funcionario){
        try {
            repository.atualizarFuncionario(funcionario);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar");
        }
    }
}
