package com.sopra.bbl.msa.event.repository;

import com.sopra.bbl.msa.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository gérant les {@link Event}
 *
 * @author jntakpe
 */
public interface EventRepository extends JpaRepository<Event, Long> {

}
