package com.unifacisa.tcc.service.notificacao;

import com.unifacisa.tcc.service.notificacao.model.TIPO_NOTIFICACAO;

public interface AbstractComunicacaoFactory {

    NotificacaoService create(TIPO_NOTIFICACAO tipoNotificacao);
}
