package com.sopra.bbl.msa.event.client;

import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Fallback du service de notification
 *
 * @author jntakpe
 */
@Component
public class NotificationServiceFallback implements NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationServiceFallback.class);

    @Override
    public void register(@RequestBody EventRegistrationDTO event) {
        LOGGER.warn("Erreur lors de l'envoi du mail d'enregistrement à l'utilisateur {} pour l'événement {}", event.getTo(),
                event.getName());
    }
}
