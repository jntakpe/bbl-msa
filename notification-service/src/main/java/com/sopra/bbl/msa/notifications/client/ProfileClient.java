package com.sopra.bbl.msa.notifications.client;

import com.sopra.bbl.msa.notifications.dto.ProfileNotificationDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client permettant de communiquer avec le service gérant les profils utilisateurs
 *
 * @author jntakpe
 */
@FeignClient(name = "profile-service", fallback = ProfileClientFallback.class)
public interface ProfileClient {

    @RequestMapping(value = "profiles/{login}", method = RequestMethod.GET)
    ProfileNotificationDTO findProfileByLogin(@PathVariable("login") String login);

}
