package com.sopra.bbl.msa.commons.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository générique basé sur {@link JpaRepository}
 *
 * @author jntakpe
 * @see JpaRepository
 * @see IdentifiableEntity
 */
public interface GenericRepostiory<E extends IdentifiableEntity> extends JpaRepository<E, Long> {

}
