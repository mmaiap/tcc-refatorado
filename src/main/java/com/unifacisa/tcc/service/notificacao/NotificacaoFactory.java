package com.unifacisa.tcc.service.notificacao;

import com.unifacisa.tcc.service.notificacao.model.TIPO_NOTIFICACAO;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class NotificacaoFactory implements ComunicacaoFactory {

    private static final Map<TIPO_NOTIFICACAO, NotificacaoService> services = new HashMap<>();

    public NotificacaoFactory() {
    }

    static {
        services.put(TIPO_NOTIFICACAO.SMS, new SMSNotificacao());
        services.put(TIPO_NOTIFICACAO.EMAIL, new EmailNotificacao());
    }

    @Override
    public NotificacaoService create(TIPO_NOTIFICACAO tipoNotificacao) {
        NotificacaoService service = services.get(tipoNotificacao);
        if (service == null) {
            throw new IllegalArgumentException("Nenhuma service encontrada para o tipo: " + tipoNotificacao);
        }
        return service;
    }
}


