package org.processor.infrastructure.messaging.serializer;

import io.quarkus.kafka.client.serialization.ObjectMapperSerializer;

public class EventSerializer<T>
        extends ObjectMapperSerializer<T> {
}