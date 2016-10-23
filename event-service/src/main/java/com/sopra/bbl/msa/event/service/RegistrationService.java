package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import com.sopra.bbl.msa.event.dto.RegistrationDTO;
import com.sopra.bbl.msa.event.messaging.NotificationSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service permettant de s'enregistrer et désinscrire d'un événement
 *
 * @author jntakpe
 */
@Service
public class RegistrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

    private final NotificationSource notificationSource;

    private final EventService eventService;

    @Autowired
    public RegistrationService(NotificationSource notificationSource, EventService eventService) {
        this.notificationSource = notificationSource;
        this.eventService = eventService;
    }

    @Transactional(readOnly = true)
    public RegistrationDTO register(Long eventId, String username) {
        Event event = eventService.findById(eventId);
        LOGGER.info("Enregistrement de l'utilisateur {} à l'événement {}", username, event.getName());
        notifyRegistration(new EventRegistrationDTO(event, username));
        return new RegistrationDTO(event.getName(), username);
    }

    private void notifyRegistration(EventRegistrationDTO event) {
        LOGGER.info("Notification à l'utilisateur {} pour l'événement {} du {}", event.getTo(), event.getName(), event.getStart());
        notificationSource.notifyRegistration(event);
    }

}
