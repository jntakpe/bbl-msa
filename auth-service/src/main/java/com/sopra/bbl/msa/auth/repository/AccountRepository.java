package com.sopra.bbl.msa.auth.repository;

import com.sopra.bbl.msa.auth.domain.Account;
import com.sopra.bbl.msa.commons.jpa.GenericRepostiory;

import java.util.Optional;

/**
 * Repository gérant l'entité {@link Account}
 *
 * @author jntakpe
 */
public interface AccountRepository extends GenericRepostiory<Account> {

    Optional<Account> findByLogin(String login);

}
