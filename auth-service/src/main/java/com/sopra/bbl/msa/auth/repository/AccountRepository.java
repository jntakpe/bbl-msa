package com.sopra.bbl.msa.auth.repository;

import com.sopra.bbl.msa.auth.domain.Account;
import com.sopra.bbl.msa.commons.jpa.GenericRepostiory;

/**
 * Repository gérant l'entité {@link Account}
 *
 * @author jntakpe
 */
public interface AccountRepository extends GenericRepostiory<Account> {

    Account findByLogin(String login);

}
