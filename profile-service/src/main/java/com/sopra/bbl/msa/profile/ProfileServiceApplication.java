package com.sopra.bbl.msa.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Classe démarrant l'application de gestion des profils
 *
 * @author jntakpe
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@EnableResourceServer
@SpringBootApplication
public class ProfileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileServiceApplication.class, args);
    }
}
