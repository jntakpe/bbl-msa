package com.sopra.bbl.msa.commons.logging;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.Span;

/**
 * Sampler Sleuth permettant d'ignorer les requêtes concernant les métriques
 *
 * @author jntakpe
 */
public class IgnoreMetricsSampler implements Sampler {

    @Override
    public boolean isSampled(Span span) {
        return !span.getName().contains("-metrics");
    }
}
