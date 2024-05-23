package com.unifacisa.tcc.service.notificacao;

import com.unifacisa.tcc.service.notificacao.model.Notificacao;
import com.unifacisa.tcc.persistence.entity.pessoa.PessoaCadastro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailNotificacao implements NotificacaoService {

    @Value("${spring.account.email}")
    private String remetente;
    @Value("${spring.account.password}")
    private String senha;

    private Properties props;

    public EmailNotificacao() {
        this.props = new Properties();
        props.put("auth", "true");
        props.put("enable", "true");
        props.put("host", "smtp@gmail.com");
        props.put("port", "587");
    }

    @Override
    public void notificar(PessoaCadastro pessoaCadastro, Notificacao notificacao) {
        this.enviarEmail(pessoaCadastro.getEmail(), notificacao.getAssunto(), notificacao.getTexto());
    }

    private void enviarEmail(String destinatario, String assunto, String corpo) {
        // Autenticação
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remetente, senha);
            }
        });

        try {
            // Criação da mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(assunto);
            message.setText(corpo);

            // Envio do email
            Transport.send(message);

            System.out.println("Email enviado com sucesso para: " + destinatario);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
