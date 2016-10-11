package com.sopra.bbl.msa.event.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client permettant de communiquer avec le module de notification
 *
 * @author jntakpe
 */
@FeignClient(name = "notification-service")
public interface NotificationService {

    @RequestMapping(value = "/mails/{to}/{event}", method = RequestMethod.GET)
    String register(@PathVariable("to") String to, @PathVariable("event") String event);

}
