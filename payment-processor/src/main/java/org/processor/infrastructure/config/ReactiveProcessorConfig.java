package org.processor.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ReactiveProcessorConfig {

    @ConfigProperty(
            name = "quarkus.vertx.event-loops-pool-size",
            defaultValue = "4"
    )
    Integer eventLoopPoolSize;

    @ConfigProperty(
            name = "quarkus.thread-pool.max-threads",
            defaultValue = "32"
    )
    Integer maxThreads;

    public Integer getEventLoopPoolSize() {
        return eventLoopPoolSize;
    }

    public Integer getMaxThreads() {
        return maxThreads;
    }
}