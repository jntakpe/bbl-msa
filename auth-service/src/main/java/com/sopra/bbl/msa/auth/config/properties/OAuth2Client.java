package com.sopra.bbl.msa.auth.config.properties;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Bean représentant la configuration d'un client OAuth2
 *
 * @author jntakpe
 */
public class OAuth2Client {

    @NotNull
    private String id;

    @NotNull
    private String secret;

    @NotEmpty
    private List<String> authorizedGrantTypes = new ArrayList<>();

    @NotEmpty
    private List<String> scopes = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public List<String> getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(List<String> authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }
}
