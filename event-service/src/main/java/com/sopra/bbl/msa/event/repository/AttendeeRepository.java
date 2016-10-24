package com.sopra.bbl.msa.event.repository;

import com.sopra.bbl.msa.commons.jpa.GenericRepostiory;
import com.sopra.bbl.msa.event.domain.Attendee;

import java.util.Optional;

/**
 * Repository gérant les {@link Attendee}
 *
 * @author jntakpe
 */
public interface AttendeeRepository extends GenericRepostiory<Attendee> {

    Optional<Attendee> findByLogin(String login);

}
