package com.sopra.bbl.msa.notifications;

import com.sopra.bbl.msa.commons.logging.IgnoreMetricsSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * Classe démarrant l'application de notification
 *
 * @author jntakpe
 */
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EnableBinding(Sink.class)
@IntegrationComponentScan
public class NotificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }

    @Bean
    public Sampler ignoreMetricsSampler() {
        return new IgnoreMetricsSampler();
    }
}
