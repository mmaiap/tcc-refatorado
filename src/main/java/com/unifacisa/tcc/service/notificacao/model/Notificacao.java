package com.unifacisa.tcc.service.notificacao.model;

import lombok.Data;

@Data
public abstract class Notificacao {

    private String texto;
    private String assunto;

}
