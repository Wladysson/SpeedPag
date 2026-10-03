package org.handler.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ReactiveConfig {

    @ConfigProperty(
            name = "quarkus.vertx.event-loops-pool-size",
            defaultValue = "4"
    )
    Integer eventLoopPoolSize;

    public Integer getEventLoopPoolSize() {
        return eventLoopPoolSize;
    }
}