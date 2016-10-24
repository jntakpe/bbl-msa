package com.sopra.bbl.msa.profile.repository;

import com.sopra.bbl.msa.commons.jpa.GenericRepostiory;
import com.sopra.bbl.msa.profile.domain.Profile;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

/**
 * Repository gérant les {@link Profile}
 *
 * @author jntakpe
 */
public interface ProfileRepository extends GenericRepostiory<Profile> {

    @EntityGraph("Profile.withNotifs")
    Optional<Profile> findByLoginIgnoreCase(String login);

    Set<Profile> findByLoginIn(Collection<String> logins);

}
