package com.sopra.bbl.msa.notifications.controller;

import com.sopra.bbl.msa.notifications.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/{to}/{event}", method = RequestMethod.GET)
    public String register(@PathVariable String to, @PathVariable String event) {
        mailService.sendRegistrationMail(to, event);
        return "Mail envoyé !!!";
    }
}
