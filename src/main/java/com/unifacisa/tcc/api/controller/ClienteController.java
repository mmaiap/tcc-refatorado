package com.unifacisa.tcc.api.controller;

import com.unifacisa.tcc.persistence.entity.pessoa.cliente.Cliente;
import com.unifacisa.tcc.service.ClienteService;
import com.unifacisa.tcc.service.financeiro.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FinanceiroService financeiroService;

    @PostMapping(path = "cliente/adicionar")
    public ResponseEntity<Cliente> adicionarCliente(@RequestBody Cliente clienteNovo){

        var client = clienteService.adicionarCliente(clienteNovo);

        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }


    @PostMapping(path = "cliente/editar")
    public ResponseEntity<HttpStatus> alterarDadosCliente(@RequestBody Cliente cliente){

        clienteService.atualizarDadosCliente(cliente);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
