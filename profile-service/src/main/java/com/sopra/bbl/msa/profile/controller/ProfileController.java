package com.sopra.bbl.msa.profile.controller;

import com.sopra.bbl.msa.profile.dto.ProfileNotificationDTO;
import com.sopra.bbl.msa.profile.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Contrôleur gérant les {@link ProfileNotificationDTO}
 *
 * @author jntakpe
 */
@RestController
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public ProfileNotificationDTO findByLogin(@PathVariable String login) {
        int i = ThreadLocalRandom.current().nextInt(0, 3);
        if (i == 0) {
            throw new IllegalStateException("Stupid exceptioon");
        }
        return profileService.findByLogin(login);
    }
}
