package com.sopra.bbl.msa.event.client;

import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author jntakpe
 */
@Component
public class NotificationClientFallback implements NotificationClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationClientFallback.class);

    @Override
    public String register(@RequestBody EventRegistrationDTO eventRegistrationDTO) {
        LOGGER.error("FALLBACK : Impossible d'envoyer le mail à {}", eventRegistrationDTO.getTo());
        return "Fallback";
    }
}
