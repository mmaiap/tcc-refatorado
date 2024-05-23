package com.unifacisa.tcc.service;

import com.unifacisa.tcc.persistence.entity.pessoa.cliente.Cliente;
import com.unifacisa.tcc.persistence.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;


    public Cliente adicionarCliente(Cliente cliente){
        try {
            return repository.inserirCliente(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao inserir cliente");
        }
    }

    public Cliente dadosCliente(Integer id) throws SQLException {
        return repository.obterClientePorId(id).
                orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public void atualizarDadosCliente(Cliente cliente) {
        try {
            repository.atualizarCliente(cliente);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar");
        }
    }


}
