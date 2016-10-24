package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.domain.Attendee;
import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.repository.AttendeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Services associés à l'entité {@link Attendee}
 *
 * @author jntakpe
 */
@Service
public class AttendeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AttendeeService.class);

    private final AttendeeRepository attendeeRepository;

    @Autowired
    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Transactional
    public Event registerAttendee(String login, Event event) {
        Attendee attendee = findByLogin(login);
        checkAlreadyRegistered(attendee, event);
        event.getAttendees().add(attendee);
        return event;
    }

    private Attendee findByLogin(String login) {
        LOGGER.debug("Recherche du participant avec le login {}", login);
        return attendeeRepository.findByLogin(login)
                .orElseThrow(() -> new IllegalStateException(String.format("Impossible de trouver le participant %s", login)));
    }

    private void checkAlreadyRegistered(Attendee attendee, Event event) {
        if (event.getAttendees().contains(attendee)) {
            LOGGER.warn("Le participant {} est déjà enregistré à l'événement {}", attendee, event);
            throw new IllegalStateException(String.format("Le participant %s est déjà enregistré à l'événement %s", attendee, event));
        }
    }
}
