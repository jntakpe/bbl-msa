package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Services gérant les événements
 *
 * @author jntakpe
 */
@Service
public class EventService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional(readOnly = true)
    public List<Event> findAll() {
        LOGGER.debug("Recherche de tous les événements");
        return eventRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Event findById(Long id) {
        LOGGER.debug("Rechecher de l'événement possédant l'id {}", id);
        return eventRepository.findOne(id);
    }

}
