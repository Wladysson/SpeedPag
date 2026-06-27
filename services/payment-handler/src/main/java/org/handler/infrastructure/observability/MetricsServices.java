package org.handler.infrastructure.observability;

import jakarta.enterprise.context.ApplicationScoped;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@ApplicationScoped
public class MetricsService {

    private final Counter paymentReceivedCounter;

    public MetricsService(
            MeterRegistry registry
    ) {

        this.paymentReceivedCounter =
                Counter.builder(
                                "payments_received_total"
                        )
                        .description(
                                "Total de pagamentos recebidos"
                        )
                        .register(registry);
    }

    public void incrementPaymentReceived() {
        paymentReceivedCounter.increment();
    }
}