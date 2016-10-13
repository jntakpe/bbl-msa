package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe de contenant les utilitaires pour les tests du service {@link EventService}
 *
 * @author jntakpe
 */
@Component
public class EventServiceTestsUtils {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceTestsUtils(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional(readOnly = true)
    public Event findAnyEvent() {
        return eventRepository.findAll().stream().findAny().orElseThrow(() -> new IllegalStateException("No events"));
    }

}
