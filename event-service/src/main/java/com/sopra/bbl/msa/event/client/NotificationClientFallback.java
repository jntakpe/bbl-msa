package com.sopra.bbl.msa.event.client;

import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jntakpe
 */
@Component
public class NotificationClientFallback implements NotificationClient {

    @Override
    public String register(@RequestBody EventRegistrationDTO eventRegistrationDTO) {
        return "Fallback";
    }
}
