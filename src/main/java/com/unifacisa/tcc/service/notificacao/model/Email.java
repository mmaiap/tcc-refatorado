package com.unifacisa.tcc.service.notificacao.model;

import lombok.Data;

@Data
public class Email extends Notificacao{

    private String assunto;
    private String destinatario;
}
