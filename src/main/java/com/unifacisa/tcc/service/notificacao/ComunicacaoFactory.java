package com.unifacisa.tcc.service.notificacao;

import com.unifacisa.tcc.service.notificacao.model.TIPO_NOTIFICACAO;

public interface ComunicacaoFactory {

    NotificacaoService create(TIPO_NOTIFICACAO tipoNotificacao);
}
