package com.sopra.bbl.msa.event.client;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Fallback du client pour le service profile
 *
 * @author jntakpe
 * @see ProfileClient
 */
@Component
public class ProfileClientFallback implements ProfileClient {

    @Override
    public Set<String> findMailsWithLogins(List<String> logins) {
        return Stream.of("fallback@mail.com").collect(Collectors.toSet());
    }
}
