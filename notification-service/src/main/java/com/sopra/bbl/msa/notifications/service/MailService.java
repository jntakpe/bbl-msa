package com.sopra.bbl.msa.notifications.service;

import com.sopra.bbl.msa.notifications.dto.EventRegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

/**
 * Service gérant les envois de mails
 *
 * @author jntakpe
 */
@Service
public class MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    private final JavaMailSender javaMailSender;

    private final MailProperties mailProperties;

    @Autowired
    public MailService(JavaMailSender javaMailSender, MailProperties mailProperties) {
        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
    }

    public void sendRegistrationMail(EventRegistrationDTO event) {
        try {
            javaMailSender.send(createMessage(event.getTo(), "Test BBL", "Enregistrement etc ..."));
            LOGGER.info("Envoi d'un mail de confirmation de participation à l'événement {} à l'addresse '{}'", event.getName(),
                    event.getTo());
        } catch (MessagingException e) {
            LOGGER.error("Impossible d'envoyer le mail d'enregistrement à {}", event.getTo());
        }
    }

    private MimeMessage createMessage(String to, String subject, String content) throws MessagingException {
        MimeMessageHelper msg = new MimeMessageHelper(javaMailSender.createMimeMessage(), false, StandardCharsets.UTF_8.name());
        msg.setTo(to);
        msg.setFrom(mailProperties.getUsername());
        msg.setSubject(subject);
        msg.setText(content, false);
        return msg.getMimeMessage();
    }

}
