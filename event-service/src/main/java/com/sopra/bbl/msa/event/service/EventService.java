package com.sopra.bbl.msa.event.service;

import com.sopra.bbl.msa.event.client.NotificationService;
import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.repository.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    private final NotificationService notificationService;

    @Autowired
    public EventService(EventRepository eventRepository, NotificationService notificationService) {
        this.eventRepository = eventRepository;
        this.notificationService = notificationService;
    }

    @Transactional(readOnly = true)
    public List<Event> findAll() {
        LOGGER.debug("Recherche de tous les événements");
        String register = notificationService.register("test", "AngularJS");
        return eventRepository.findAll().stream().map(e -> {
            e.setName(register);
            return e;
        }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Event findById(Long id) {
        LOGGER.debug("Rechecher de l'événement possédant l'id {}", id);
        return eventRepository.findOne(id);
    }

}
