package com.sopra.bbl.msa.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Classe démarrant le service de gestion des événements
 *
 * @author jntakpe
 */
@EnableHystrix
@EnableFeignClients
@EnableResourceServer
@SpringBootApplication
@EnableDiscoveryClient
public class EventServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventServiceApplication.class, args);
    }
}
