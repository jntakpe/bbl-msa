package com.sopra.bbl.msa.profile.controller;

import com.sopra.bbl.msa.profile.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Controller gérant les adresses mails des profils
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("mails")
public class MailController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MailController.class);

    private final ProfileService profileService;

    private int callCount = 0;

    @Autowired
    public MailController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Set<String> findMailsWithLogins(@RequestParam Set<String> logins) {
        LOGGER.info("Call Profiles " + ++callCount);
        return profileService.findMailsWithLogins(logins);
    }
}
