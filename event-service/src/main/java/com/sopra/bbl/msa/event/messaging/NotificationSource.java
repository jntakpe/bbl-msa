package com.sopra.bbl.msa.event.messaging;

import com.sopra.bbl.msa.event.dto.EventRegistrationDTO;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Canal de communication avec le service de notifications
 *
 * @author jntakpe
 */
@MessagingGateway
public interface NotificationSource {

    @Gateway(requestChannel = Source.OUTPUT)
    void notifyRegistration(EventRegistrationDTO eventRegistrationDTO);

}
