package com.sopra.bbl.msa.event.client;

import org.springframework.stereotype.Component;

/**
 * @author jntakpe
 */
@Component
public class NotificationServiceFallback implements NotificationService {

    @Override
    public String register(String to, String event) {
        return "FALLBACK";
    }
}
