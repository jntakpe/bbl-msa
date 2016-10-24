package com.sopra.bbl.msa.commons.logging;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration de Sleuth
 *
 * @author jntakpe
 */
@Configuration
public class SleuthConfig {

    @Bean
    public Sampler ignoreMetricsSampler() {
        return new IgnoreMetricsSampler();
    }

}
