package com.unifacisa.tcc.service.notificacao;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import com.unifacisa.tcc.service.notificacao.model.Notificacao;
import com.unifacisa.tcc.persistence.entity.pessoa.PessoaCadastro;
import org.springframework.stereotype.Service;

@Service
public class SMSNotificacao implements NotificacaoService {

    private static String NUMERO_EMPRESA = "83998980000";

    public SMSNotificacao() {
        Twilio.init("id", "token");
    }

    private void enviarSMS(String numero, String mensagem) {
        com.twilio.rest.api.v2010.account.Message.creator(
                new PhoneNumber(numero),
                new PhoneNumber(NUMERO_EMPRESA),
                mensagem
        ).create();
    }

    @Override
    public void notificar(PessoaCadastro pessoaCadastro, Notificacao notificacao) {

        this.enviarSMS(pessoaCadastro.getTelefone(), notificacao.getTexto());
    }
}
