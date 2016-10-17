package com.sopra.bbl.msa.auth.config.properties;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
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

    @NotNull
    private String certFilePath;

    @NotNull
    private String certPassword;

    @NotEmpty
    private List<OAuth2Client> clients = new ArrayList<>();

    public String getCertFilePath() {
        return certFilePath;
    }

    public void setCertFilePath(String certFilePath) {
        this.certFilePath = certFilePath;
    }

    public String getCertPassword() {
        return certPassword;
    }

    public void setCertPassword(String certPassword) {
        this.certPassword = certPassword;
    }

    public List<OAuth2Client> getClients() {
        return clients;
    }

    public void setClients(List<OAuth2Client> clients) {
        this.clients = clients;
    }
}
