package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.client.NotificationClient;
import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import com.sopra.bbl.msa.event.dto.RegistrationDTO;
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

    private final EventService eventService;

    private final AttendeeService attendeeService;

    private final NotificationClient notificationClient;

    @Autowired
    public RegistrationService(EventService eventService, AttendeeService attendeeService, NotificationClient notificationClient) {
        this.eventService = eventService;
        this.attendeeService = attendeeService;
        this.notificationClient = notificationClient;
    }

    @Transactional
    public RegistrationDTO register(Long eventId, String username) {
        Event event = eventService.findById(eventId);
        attendeeService.registerAttendee(username, event);
        LOGGER.info("Enregistrement de l'utilisateur {} à l'événement {}", username, event.getName());
        String ret = notifyRegistration(new EventRegistrationDTO(event, username));
        LOGGER.info("Mail envoyé à l'utilisateur {}", ret);
        return new RegistrationDTO(event.getName(), username);
    }

    public String notifyRegistration(EventRegistrationDTO event) {
        LOGGER.info("Notification à l'utilisateur {} pour l'événement {} du {}", event.getTo(), event.getName(), event.getStart());
        return notificationClient.register(event);
    }

}
