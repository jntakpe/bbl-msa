package com.sopra.bbl.msa.event.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

/**
 * @author jntakpe
 */
@FeignClient(name = "profile-service", fallback = ProfileClientFallback.class)
public interface ProfileClient {

    @RequestMapping(value = "/mails", method = RequestMethod.GET)
    Set<String> findMailsWithLogins(@RequestParam("logins") List<String> logins);

}
