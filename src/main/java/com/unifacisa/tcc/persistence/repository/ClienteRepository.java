package com.unifacisa.tcc.persistence.repository;

import com.unifacisa.tcc.persistence.entity.pessoa.cliente.Cliente;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public interface ClienteRepository {

    public Optional<Cliente> obterClientePorId(int id) throws SQLException;

    public void atualizarCliente(Cliente cliente) throws SQLException;

    public Cliente inserirCliente(Cliente cliente) throws SQLException;
}
