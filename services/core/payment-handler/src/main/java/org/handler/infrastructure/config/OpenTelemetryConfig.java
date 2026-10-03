package org.handler.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class OpenTelemetryConfig {

    @ConfigProperty(
            name = "quarkus.otel.exporter.otlp.endpoint"
    )
    String otlpEndpoint;

    @ConfigProperty(
            name = "quarkus.application.name"
    )
    String applicationName;

    public String getOtlpEndpoint() {
        return otlpEndpoint;
    }

    public String getApplicationName() {
        return applicationName;
    }
}