package com.unifacisa.tcc.api.controller;

import com.unifacisa.tcc.service.notificacao.model.Notificacao;
import com.unifacisa.tcc.service.notificacao.model.TIPO_NOTIFICACAO;
import com.unifacisa.tcc.service.ClienteService;
import com.unifacisa.tcc.service.FuncionarioService;
import com.unifacisa.tcc.service.notificacao.NotificacaoFactory;
import com.unifacisa.tcc.service.notificacao.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class NotificacaoController {

    @Autowired
    private FuncionarioService funcionarioService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private NotificacaoFactory factory;

    @PostMapping(path = "notificacao/colaborador/{matricula}/notificar")
    public ResponseEntity<HttpStatus> notificarColaborador(@RequestBody Notificacao notificacao, @PathVariable Integer matricula,
                                                           TIPO_NOTIFICACAO tipoNotificacao) throws SQLException {

        var dadosColaborador = funcionarioService.dadosColaborador(matricula);
        NotificacaoService notificacaoService = factory.create(tipoNotificacao);
        notificacaoService.notificar(dadosColaborador, notificacao);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "notificacao/cliente/{id}/notificar")
    public ResponseEntity<HttpStatus> notificarCliente(@RequestBody Notificacao notificacao, @PathVariable Integer id,
                                                       TIPO_NOTIFICACAO tipoNotificacao) throws SQLException {

        var dadosCliente = clienteService.dadosCliente(id);
        NotificacaoService notificacaoService = factory.create(tipoNotificacao);
        notificacaoService.notificar(dadosCliente, notificacao);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
