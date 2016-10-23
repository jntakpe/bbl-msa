package com.sopra.bbl.msa.notifications.controller;

import com.sopra.bbl.msa.notifications.dto.EventRegistrationDTO;
import com.sopra.bbl.msa.notifications.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Contrôleur gérant les envois de mails
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("mails")
public class MailController {

    private final MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody EventRegistrationDTO eventRegistrationDTO) {
        return mailService.sendRegistrationMail(eventRegistrationDTO);
    }

}
