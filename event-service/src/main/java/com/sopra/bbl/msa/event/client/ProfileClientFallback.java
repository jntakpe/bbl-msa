package com.sopra.bbl.msa.event.client;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Fallback du client {@link ProfileClient}
 *
 * @author jntakpe
 */
@Component
public class ProfileClientFallback implements ProfileClient {

    @Override
    public Set<String> findMailsWithLogins(@RequestParam("logins") List<String> logins) {
        return Stream.of("Fallback").collect(Collectors.toSet());
    }
}
