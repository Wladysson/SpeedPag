package org.processor.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class KafkaProcessorConfig {

    @ConfigProperty(
            name = "kafka.bootstrap.servers"
    )
    String bootstrapServers;

    @ConfigProperty(
            name = "mp.messaging.incoming.payment-requested.topic"
    )
    String paymentRequestedTopic;

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public String getPaymentRequestedTopic() {
        return paymentRequestedTopic;
    }
}