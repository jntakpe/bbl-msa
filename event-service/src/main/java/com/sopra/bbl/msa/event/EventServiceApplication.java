package com.sopra.bbl.msa.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Classe démarrant le service de gestion des événements
 *
 * @author jntakpe
 */
@EnableHystrix
@EnableResourceServer
@SpringBootApplication
@EnableDiscoveryClient
@IntegrationComponentScan
@EnableBinding(Source.class)
@EnableGlobalMethodSecurity(jsr250Enabled = true, proxyTargetClass = true)
public class EventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventServiceApplication.class, args);
    }
}
