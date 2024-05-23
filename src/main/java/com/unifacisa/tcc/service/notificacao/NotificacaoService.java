package com.unifacisa.tcc.service.notificacao;

import com.unifacisa.tcc.service.notificacao.model.Notificacao;
import com.unifacisa.tcc.persistence.entity.pessoa.PessoaCadastro;
import org.springframework.stereotype.Service;

@Service
public interface NotificacaoService {

    public void notificar(PessoaCadastro pessoaCadastro, Notificacao notificacao);
}
