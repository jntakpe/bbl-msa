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

import java.security.Principal;
import java.util.Set;

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

    @RequestMapping(value = "/{eventId}/attendees/mails", method = RequestMethod.GET)
    public Set<String> findAttendeesMails(@PathVariable Long eventId) {
        return eventService.findAttendeesMails(eventId);
    }

    @RequestMapping(value = "/{eventId}/register", method = RequestMethod.PUT)
    public RegistrationDTO register(@PathVariable Long eventId, Principal principal) {
        return registrationService.register(eventId, principal.getName());
    }

    @RequestMapping(value = "/{eventId}/register/{username}", method = RequestMethod.PUT)
    public RegistrationDTO register(@PathVariable Long eventId, @PathVariable String username) {
        return registrationService.register(eventId, username);
    }

}
