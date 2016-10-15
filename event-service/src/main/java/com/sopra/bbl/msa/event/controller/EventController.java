package com.sopra.bbl.msa.event.controller;

import com.sopra.bbl.msa.event.domain.Event;
import com.sopra.bbl.msa.event.dto.RegistrationDTO;
import com.sopra.bbl.msa.event.service.EventService;
import com.sopra.bbl.msa.event.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contrôleur gérant les {@link Event}
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("events")
public class EventController {

    private final EventService eventService;

    private final RegistrationService registrationService;

    @Autowired
    public EventController(EventService eventService, RegistrationService registrationService) {
        this.eventService = eventService;
        this.registrationService = registrationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Event> findAll() {
        return eventService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event findById(@PathVariable Long id) {
        return eventService.findById(id);
    }

    @RequestMapping(value = "/{eventId}/register/{userId}", method = RequestMethod.PUT)
    public RegistrationDTO register(@PathVariable Long eventId, @PathVariable(required = false) Long userId) {
        return registrationService.register(eventId, userId);
    }

}
