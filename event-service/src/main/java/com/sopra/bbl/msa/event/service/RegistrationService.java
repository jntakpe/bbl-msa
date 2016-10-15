package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.client.NotificationService;
import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import com.sopra.bbl.msa.event.dto.RegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Service permettant de s'enregistrer et désinscrire d'un événement
 *
 * @author jntakpe
 */
@Service
public class RegistrationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationService.class);

    private final NotificationService notificationService;

    private final EventService eventService;

    @Autowired
    public RegistrationService(NotificationService notificationService, EventService eventService) {
        this.notificationService = notificationService;
        this.eventService = eventService;
    }

    @Transactional
    public RegistrationDTO register(Long eventId, Long userId) {
        Event event = eventService.findById(eventId);
        String email = "jocelyn.ntakpe@soprasteria.com";
        LOGGER.info("Enregistrement de l'utilisateur {} à l'événement {}", email, event.getName());
        notificationService.register(new EventRegistrationDTO(event, email));
        return new RegistrationDTO(event.getName(), email);
    }

}
