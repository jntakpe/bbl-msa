package com.sopra.bbl.msa.profile.service;

import com.sopra.bbl.msa.profile.domain.Profile;
import com.sopra.bbl.msa.profile.dto.ProfileNotificationDTO;
import com.sopra.bbl.msa.profile.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Services associés à l'entité {@link Profile}
 *
 * @author jntakpe
 */
@Service
public class ProfileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfileService.class);

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Transactional(readOnly = true)
    public ProfileNotificationDTO findByLogin(String login) {
        LOGGER.debug("Recherche du profil de l'utilisateur {}", login);
        return profileRepository.findByLoginIgnoreCase(login)
                .map(ProfileNotificationDTO::new)
                .orElseThrow(() -> new UsernameNotFoundException("Impossible de trouver le profile de l'utilisateur login"));
    }
}
