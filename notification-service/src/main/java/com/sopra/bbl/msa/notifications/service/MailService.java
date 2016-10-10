package com.sopra.bbl.msa.notifications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service gérant les envois de mails
 *
 * @author jntakpe
 */
@Service
public class MailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);

    public void sendRegistrationMail(String to, String event) {
        LOGGER.info("Envoi d'un mail de confirmation de participation à l'événement {} à l'addresse '{}'", event, to);
        // TODO perform some stuff
    }

}
