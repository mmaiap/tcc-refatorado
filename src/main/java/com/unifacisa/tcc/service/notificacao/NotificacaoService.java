package com.unifacisa.tcc.service.notificacao;

import com.unifacisa.tcc.persistence.entity.pessoa.PessoaCadastro;
import com.unifacisa.tcc.service.notificacao.model.Notificacao;

public interface NotificacaoService {

    public void notificar(PessoaCadastro pessoaCadastro, Notificacao notificacao);
}
