package com.sopra.bbl.msa.auth.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implémentation de {@link UserDetailsService} permettant de récupérer en base de données un utilisateur
 *
 * @author jntakpe
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("fakeuser", "pwd", AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
    }

}
