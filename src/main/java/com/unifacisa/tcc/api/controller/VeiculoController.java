package com.unifacisa.tcc.api.controller;

import com.unifacisa.tcc.persistence.entity.veiculos.Carro;
import com.unifacisa.tcc.persistence.entity.veiculos.CarroEletrico;
import com.unifacisa.tcc.persistence.entity.veiculos.Moto;
import com.unifacisa.tcc.persistence.entity.veiculos.VeiculoCombustao;
import com.unifacisa.tcc.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping(path = "veiculo/carro")
    public ResponseEntity<Carro> getCarro(@RequestBody Carro carroRequest) throws SQLException {
        Carro carro = veiculoService.getCarro(carroRequest.getId());
        return new ResponseEntity<>(carro, HttpStatus.OK);
    }

    @PostMapping(path = "veiculo/carro/adicionar")
    public ResponseEntity<Carro> adicionarCarro(@RequestBody Carro carroNovo) throws SQLException {
        Carro carro = veiculoService.inserirCarro(carroNovo);
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }

    @GetMapping(path = "veiculo/carroEletrico")
    public ResponseEntity<CarroEletrico> getCarroEletrico(@RequestBody CarroEletrico carroEletricoRequest) throws SQLException {
        CarroEletrico carroEletrico = veiculoService.getCarroEletrico(carroEletricoRequest.getId());
        return new ResponseEntity<>(carroEletrico, HttpStatus.OK);
    }

    @PostMapping(path = "veiculo/carroEletrico/adicionar")
    public ResponseEntity<CarroEletrico> adicionarCarroEletrico(@RequestBody CarroEletrico carroEletricoNovo) throws SQLException {
        CarroEletrico carroEletrico = veiculoService.inserirCarroEletrico(carroEletricoNovo);
        return new ResponseEntity<>(carroEletrico, HttpStatus.CREATED);
    }

    @GetMapping(path = "veiculo/moto")
    public ResponseEntity<Moto> getMoto(@RequestBody Moto motoRequest) throws SQLException {
        Moto moto = veiculoService.getMoto(motoRequest.getId());
        return new ResponseEntity<>(moto, HttpStatus.OK);
    }

    @PostMapping(path = "veiculo/moto/adicionar")
    public ResponseEntity<Moto> adicionarMoto(@RequestBody Moto motoNova) throws SQLException {
        Moto moto = veiculoService.inserirMoto(motoNova);
        return new ResponseEntity<>(moto, HttpStatus.CREATED);
    }

    @GetMapping(path = "veiculo/valorTanqueCheio")
    public ResponseEntity<BigDecimal> getValorTanqueCheio(@RequestBody VeiculoCombustao veiculo, BigDecimal valorCombustivelDia) throws SQLException {

        BigDecimal valor = veiculoService.getValorTanqueCheio(valorCombustivelDia, veiculo);

        return new ResponseEntity<>(valor, HttpStatus.OK);
    }
}
