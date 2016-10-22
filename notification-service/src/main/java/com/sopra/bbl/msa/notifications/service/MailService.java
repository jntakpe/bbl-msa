package com.sopra.bbl.msa.notifications.service;

import com.sopra.bbl.msa.notifications.client.ProfileService;
import com.sopra.bbl.msa.notifications.dto.EventRegistrationDTO;
import com.sopra.bbl.msa.notifications.dto.ProfileNotificationDTO;
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
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Service gérant les envois de mails
 *
 * @author jntakpe
 */
@Service
public class MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    private static final String CONFIRMATION_SUBJECT = "Confirmation participation BBL";

    private final JavaMailSender javaMailSender;

    private final MailProperties mailProperties;

    private final ProfileService profileService;

    @Autowired
    public MailService(JavaMailSender javaMailSender, MailProperties mailProperties, ProfileService profileService) {
        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
        this.profileService = profileService;
    }

    public void sendRegistrationMail(EventRegistrationDTO event) {
        ProfileNotificationDTO profile = findProfileInfos(event.getTo());
        try {
            javaMailSender.send(createMessage(profile.getEmail(), CONFIRMATION_SUBJECT, mailText(event, profile)));
            LOGGER.info("Envoi d'un mail de confirmation de participation à l'événement {} à l'addresse '{}'", event.getName(),
                    event.getTo());
        } catch (MessagingException e) {
            LOGGER.error("Impossible d'envoyer le mail d'enregistrement à {}", event.getTo());
            throw new RuntimeException(e);
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

    private ProfileNotificationDTO findProfileInfos(String login) {
        Objects.requireNonNull(login);
        LOGGER.debug("Récupération du profil de l'utilisateur {}", login);
        return profileService.findProfileByLogin(login);
    }

    private String mailText(EventRegistrationDTO event, ProfileNotificationDTO profile) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add(String.format("Bonjour %s,", profile.getFirstName()));
        joiner.add(String.format("Votre enregistrement au %s %s du %s a été prise en compte", event.getType(), event.getName(),
                event.getStart()));
        return joiner.toString();
    }

}
