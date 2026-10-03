package org.handler.infrastructure.messaging;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Metadata;

import io.smallrye.reactive.messaging.kafka.api.OutgoingKafkaRecordMetadata;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@ApplicationScoped
public class KafkaHeadersFactory {

    public Metadata create(
            String paymentId
    ) {

        return Metadata.of(
                OutgoingKafkaRecordMetadata.builder()
                        .withKey(paymentId)
                        .withHeader(
                                "event-id",
                                UUID.randomUUID()
                                        .toString()
                                        .getBytes(
                                                StandardCharsets.UTF_8
                                        )
                        )
                        .withHeader(
                                "correlation-id",
                                paymentId.getBytes(
                                        StandardCharsets.UTF_8
                                )
                        )
                        .build()
        );
    }
}