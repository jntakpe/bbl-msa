package com.sopra.bbl.msa.event.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Set;

/**
 * Client permettant de communiquer avec le service profiles
 *
 * @author jntakpe
 */
@Component
public class ProfileClient {

    private final RestTemplate restTemplate;

    @Autowired
    public ProfileClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Set<String> findMailsWithLogins(List<String> logins) {
        UriComponents req = UriComponentsBuilder.fromHttpUrl("http://localhost:8280/mails").queryParam("logins", logins.toArray()).build();
        System.out.println(req.toString());
        return restTemplate.getForEntity(req.toString(), Set.class).getBody();
    }
}
