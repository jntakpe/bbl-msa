package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.client.ProfileClient;
import com.sopra.bbl.msa.event.domain.Attendee;
import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Services gérant les événements
 *
 * @author jntakpe
 */
@Service
public class EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;

    private final ProfileClient profileClient;

    @Autowired
    public EventService(EventRepository eventRepository, ProfileClient profileClient) {
        this.eventRepository = eventRepository;
        this.profileClient = profileClient;
    }

    @Transactional(readOnly = true)
    public Set<String> findAttendeesMails(Long eventId) {
        LOGGER.info("Recherche des mails des participants à l'événement id {}", eventId);
        List<String> logins = findAttendeesLogin(eventId);
        if (logins.isEmpty()) {
            return Collections.emptySet();
        }
        return profileClient.findMailsWithLogins(logins);
    }

    @Transactional(readOnly = true)
    public Event findById(Long id) {
        LOGGER.debug("Rechecher de l'événement possédant l'id {}", id);
        Event event = eventRepository.findOne(id);
        if (event == null) {
            LOGGER.warn("Impossible de trouver un événement possédant l'id : {}", id);
            throw new EntityNotFoundException(String.format("Impossible de trouver un événement possédant l'id : %s", id));
        }
        return event;
    }

    private List<String> findAttendeesLogin(Long eventId) {
        return eventRepository.findOne(eventId).getAttendees().stream().map(Attendee::getLogin).collect(Collectors.toList());
    }

}
