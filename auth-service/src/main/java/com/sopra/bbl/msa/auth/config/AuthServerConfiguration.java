package com.sopra.bbl.msa.auth.config;

import com.sopra.bbl.msa.auth.config.properties.OAuth2Client;
import com.sopra.bbl.msa.auth.config.properties.OAuth2Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**
 * Configuration du serveur authorization
 *
 * @author jntakpe
 * @see AuthorizationServerConfigurerAdapter
 */
@Configuration
@EnableAuthorizationServer
public class AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

    public static final String CERT_ALIAS = "bblmsacert";

    private final AuthenticationManager authenticationManager;

    private final OAuth2Properties oAuth2Properties;

    private final ResourceLoader resourceLoader;

    @Autowired
    public AuthServerConfiguration(AuthenticationManager authenticationManager,
                                   OAuth2Properties oAuth2Properties,
                                   ResourceLoader resourceLoader) {
        this.authenticationManager = authenticationManager;
        this.oAuth2Properties = oAuth2Properties;
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        Resource cert = resourceLoader.getResource(oAuth2Properties.getCertFilePath());
        KeyPair keyPair = new KeyStoreKeyFactory(cert, oAuth2Properties.getCertPassword().toCharArray()).getKeyPair(CERT_ALIAS);
        jwtAccessTokenConverter.setKeyPair(keyPair);
        return jwtAccessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
        oAuth2Properties.getClients().forEach(client -> configureClient(configurer, client));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())
                .accessTokenConverter(jwtAccessTokenConverter())
                .authenticationManager(this.authenticationManager);
    }

    private void configureClient(ClientDetailsServiceConfigurer configurer, OAuth2Client client) {
        try {
            configurer
                    .inMemory()
                    .withClient(client.getId())
                    .secret(client.getSecret())
                    .authorizedGrantTypes(client.getAuthorizedGrantTypes().stream().toArray(String[]::new))
                    .scopes(client.getScopes().stream().toArray(String[]::new));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
