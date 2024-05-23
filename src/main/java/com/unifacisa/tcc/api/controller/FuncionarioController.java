package com.unifacisa.tcc.api.controller;

import com.unifacisa.tcc.persistence.entity.pessoa.colaborador.Funcionario;
import com.unifacisa.tcc.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping(path = "colaborador/adicionar")
    public ResponseEntity<Funcionario> adicionarColaborador(@RequestBody Funcionario funcionarioNovo){

        var colab = funcionarioService.adicionarColaborador(funcionarioNovo);

        return new ResponseEntity<>(colab, HttpStatus.CREATED);
    }
}
