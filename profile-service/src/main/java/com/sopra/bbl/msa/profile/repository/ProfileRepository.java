package com.sopra.bbl.msa.profile.repository;

import com.sopra.bbl.msa.commons.jpa.GenericRepostiory;
import com.sopra.bbl.msa.profile.domain.Profile;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.Optional;

/**
 * Repository gérant les {@link Profile}
 *
 * @author jntakpe
 */
public interface ProfileRepository extends GenericRepostiory<Profile> {

    @EntityGraph("Profile.withNotifs")
    Optional<Profile> findByLoginIgnoreCase(String login);

}
