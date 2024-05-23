package com.unifacisa.tcc.api.controller;

import com.unifacisa.tcc.persistence.entity.pessoa.cliente.Cliente;
import com.unifacisa.tcc.service.FuncionarioService;
import com.unifacisa.tcc.service.financeiro.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class FinanceiroController {

    @Autowired
    private FinanceiroService financeiroService;

    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping(path = "financeiro/cliente/{id}/desconto")
    public ResponseEntity<BigDecimal> calcularDesconto(@RequestBody Cliente clienteNovo){

        var desconto = financeiroService.calcularDesconto(clienteNovo);

        return new ResponseEntity<>(desconto, HttpStatus.OK);
    }

    @GetMapping(value = "financeiro/colaborador/buscar/{matricula}/bonus")
    public ResponseEntity<BigDecimal> calcularBonus(@PathVariable Integer matricula) throws SQLException {

        var colaborador = funcionarioService.dadosColaborador(matricula);

        BigDecimal bonus = financeiroService.calcularBonusAnual(colaborador.getDataAdmissao(), colaborador.getCargoFuncionario(), colaborador.getSalario());

        return new ResponseEntity<>(bonus, HttpStatus.OK);
    }

    @GetMapping(value = "financeiro/colaborador/buscar/{matricula}")
    public ResponseEntity<String> gerarRelatorioColaborador(@PathVariable Integer matricula) throws SQLException {

        var dadosColaborador = funcionarioService.dadosColaborador(matricula);

        String relatorio = financeiroService.gerarRelatorioFuncionario(dadosColaborador);

        return new ResponseEntity<>(relatorio, HttpStatus.OK);
    }

    @GetMapping(value = "financeiro/colaborador/buscar/{matricula}/salario")
    public ResponseEntity<BigDecimal> retornarSalario(@PathVariable Integer matricula) throws SQLException {

        var dadosColaborador = funcionarioService.dadosColaborador(matricula);

        BigDecimal salario = financeiroService.retornaSalarioBase(dadosColaborador.getCargoFuncionario());

        return new ResponseEntity<>(salario, HttpStatus.OK);
    }
}
