package com.sopra.bbl.msa.notifications.service;

import com.sopra.bbl.msa.notifications.client.ProfileClient;
import com.sopra.bbl.msa.notifications.dto.EventRegistrationDTO;
import com.sopra.bbl.msa.notifications.dto.NotificationType;
import com.sopra.bbl.msa.notifications.dto.ProfileNotificationDTO;
import org.apache.commons.lang3.StringUtils;
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
import java.util.Optional;
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

    private final ProfileClient profileClient;

    @Autowired
    public MailService(JavaMailSender javaMailSender, MailProperties mailProperties, ProfileClient profileClient) {
        this.javaMailSender = javaMailSender;
        this.mailProperties = mailProperties;
        this.profileClient = profileClient;
    }

    public String sendRegistrationMail(EventRegistrationDTO event) {
        LOGGER.info("Réception du message de confirmation à l'événement {} pour l'utilisateur {}", event.getName(), event.getTo());
        findProfileInfos(event.getTo())
                .filter(this::authorizeRegistrationNotification)
                .map(p -> createMessage(p.getEmail(), CONFIRMATION_SUBJECT, mailText(event, p)))
                .ifPresent(m -> sendMail(event, m));
        return event.getTo();
    }

    private void sendMail(EventRegistrationDTO event, MimeMessage message) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
        LOGGER.info("Envoi d'un mail de confirmation de participation à l'événement {} à {}", event.getName(), event.getTo());
    }

    private boolean authorizeRegistrationNotification(ProfileNotificationDTO profile) {
        boolean authorize = profile.getNotifications().contains(NotificationType.REGISTRATION);
        if (!authorize) {
            LOGGER.warn("L'utilisateur {} n'autorise pas les notifications d'enregistrement aux sessions", profile.getLogin());
        }
        return authorize;
    }

    private MimeMessage createMessage(String to, String subject, String content) {
        try {
            MimeMessageHelper msg = new MimeMessageHelper(javaMailSender.createMimeMessage(), false, StandardCharsets.UTF_8.name());
            msg.setTo(to);
            msg.setFrom(mailProperties.getUsername());
            msg.setSubject(subject);
            msg.setText(content, false);
            return msg.getMimeMessage();
        } catch (MessagingException e) {
            LOGGER.error("Impossible d'envoyer le mail d'enregistrement à {}", to);
            throw new RuntimeException(e);
        }
    }

    private Optional<ProfileNotificationDTO> findProfileInfos(String login) {
        Objects.requireNonNull(login);
        LOGGER.debug("Récupération du profil de l'utilisateur {}", login);
        return Optional.ofNullable(profileClient.findProfileByLogin(login));
    }

    private String mailText(EventRegistrationDTO event, ProfileNotificationDTO profile) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add(String.format("Bonjour %s,", profile.getFirstName()));
        joiner.add(StringUtils.EMPTY);
        joiner.add(StringUtils.EMPTY);
        joiner.add(String.format("Votre participation au %s %s du %s a été prise en compte", event.getType(), event.getName(),
                event.getStart()));
        joiner.add(StringUtils.EMPTY);
        joiner.add("Cordialement,");
        joiner.add(StringUtils.EMPTY);
        joiner.add("La communauté architecture");
        return joiner.toString();
    }

}
