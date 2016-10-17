package com.sopra.bbl.msa.commons.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Utilitaires de sécurité
 *
 * @author jntakpe
 */
public final class SecurityUtils {

    public static final String ROLE_PREFIX = "ROLE_";

    private SecurityUtils() {
    }

    public static Optional<User> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return Optional.of((User) authentication.getPrincipal());
        }
        return Optional.empty();
    }

    public static User getCurrentUserOrThrow() {
        return getCurrentUser().orElseThrow(() -> new UsernameNotFoundException("Impossible de récupérer l'utilisateur courant"));
    }

    public static List<SimpleGrantedAuthority> authoritiesToSimpleGrant(Set<String> authorities) {
        if (authorities.isEmpty()) {
            return Collections.singletonList(new SimpleGrantedAuthority(AuthoritiesConstants.USER));
        }
        return authorities.stream()
                .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role))
                .collect(Collectors.toList());
    }


}
