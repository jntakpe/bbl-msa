package com.sopra.bbl.msa.auth.service;

import com.sopra.bbl.msa.auth.domain.Account;
import com.sopra.bbl.msa.auth.domain.Authority;
import com.sopra.bbl.msa.auth.repository.AccountRepository;
import com.sopra.bbl.msa.commons.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implémentation de {@link UserDetailsService} permettant de récupérer en base de données un utilisateur
 *
 * @author jntakpe
 */
@Service
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(login);
        List<String> authsNames = account.getAuthorities().stream()
                .map(Authority::getName)
                .map(role -> SecurityUtils.ROLE_PREFIX + role)
                .collect(Collectors.toList());
        List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(authsNames.toArray(new String[authsNames.size()]));
        return new User(account.getLogin(), account.getPassword(), auths);
    }

}
