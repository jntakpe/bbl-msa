package com.sopra.bbl.msa.profile.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sopra.bbl.msa.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.Set;

/**
 * Controller gérant les adresses mails des profils
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("mails")
public class MailController {

    private final ProfileService profileService;

    @Autowired
    public MailController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @HystrixCommand
    @RequestMapping(method = RequestMethod.GET)
    public Set<String> findMailsWithLogins(@RequestParam Set<String> logins) {
        if (new Random().nextInt(4) + 1 < 4) {
            throw new IllegalStateException("Random error");
        }
        return profileService.findMailsWithLogins(logins);
    }
}
