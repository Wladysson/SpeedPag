package org.processor.infrastructure.observability;

import jakarta.enterprise.context.ApplicationScoped;

import org.jboss.logging.Logger;

@ApplicationScoped
public class LagMetricsCollector {

    private static final Logger LOG =
            Logger.getLogger(
                    LagMetricsCollector.class
            );

    public void collect() {

        LOG.info(
                "Coletando metricas de lag Kafka"
        );
    }
}