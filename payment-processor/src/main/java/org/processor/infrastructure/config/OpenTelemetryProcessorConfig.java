package org.processor.infrastructure.config;

import jakarta.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class OpenTelemetryProcessorConfig {

    @ConfigProperty(
            name = "quarkus.application.name"
    )
    String applicationName;

    @ConfigProperty(
            name = "quarkus.otel.exporter.otlp.endpoint"
    )
    String otlpEndpoint;

    @ConfigProperty(
            name = "quarkus.otel.enabled",
            defaultValue = "true"
    )
    Boolean telemetryEnabled;

    public String getApplicationName() {
        return applicationName;
    }

    public String getOtlpEndpoint() {
        return otlpEndpoint;
    }

    public Boolean isTelemetryEnabled() {
        return telemetryEnabled;
    }
}