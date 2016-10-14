package com.sopra.bbl.msa.event.client;

import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jntakpe
 */
@Component
public class NotificationServiceFallback implements NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceFallback.class);

    @Override
    public void register(@RequestBody EventRegistrationDTO event) {
        LOGGER.warn("Impossible d'envoyer le mail d'enregistrement à l'utilisateur {} pour l'événement {}", event.getTo(), event.getName());
    }
}
