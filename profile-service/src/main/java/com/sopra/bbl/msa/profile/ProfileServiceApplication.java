package com.sopra.bbl.msa.profile;

import com.sopra.bbl.msa.commons.logging.IgnoreMetricsSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.context.annotation.Bean;

/**
 * Classe démarrant l'application de gestion des profils
 *
 * @author jntakpe
 */
@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ProfileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileServiceApplication.class, args);
    }

    @Bean
    public Sampler ignoreMetricsSampler() {
        return new IgnoreMetricsSampler();
    }
}
