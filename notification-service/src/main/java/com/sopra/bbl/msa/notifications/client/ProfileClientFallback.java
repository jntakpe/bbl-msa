package com.sopra.bbl.msa.notifications.client;

import com.sopra.bbl.msa.notifications.dto.ProfileNotificationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author jntakpe
 */
@Component
public class ProfileClientFallback implements ProfileClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileClientFallback.class);

    @Override
    public ProfileNotificationDTO findProfileByLogin(String login) {
        LOGGER.warn("Impossible de récupérer les informations de l'utilisateur {}", login);
        return null;
    }
}
