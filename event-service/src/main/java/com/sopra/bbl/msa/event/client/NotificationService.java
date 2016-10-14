package com.sopra.bbl.msa.event.client;

import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client permettant de communiquer avec le module de notification
 *
 * @author jntakpe
 */
@FeignClient(name = "notification-service", fallback = NotificationServiceFallback.class)
public interface NotificationService {

    @RequestMapping(value = "/mails/register", method = RequestMethod.POST)
    void register(@RequestBody EventRegistrationDTO eventRegistrationDTO);

}
