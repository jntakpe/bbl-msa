package com.sopra.bbl.msa.auth.config.properties;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Propriétés relatives à l'authentification OAuth2
 *
 * @author jntakpe
 */
@Component
@ConfigurationProperties("auth.oauth2")
public class OAuth2Properties {

    @NotEmpty
    private List<OAuth2Client> clients = new ArrayList<>();

    public List<OAuth2Client> getClients() {
        return clients;
    }

    public void setClients(List<OAuth2Client> clients) {
        this.clients = clients;
    }
}
