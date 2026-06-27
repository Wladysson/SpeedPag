package org.processor.infrastructure.observability;

import jakarta.enterprise.context.ApplicationScoped;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@ApplicationScoped
public class PaymentMetrics {

    private final Counter
            paymentProcessedCounter;

    private final Counter
            paymentFailedCounter;

    public PaymentMetrics(
            MeterRegistry registry
    ) {

        this.paymentProcessedCounter =
                Counter.builder(
                                "payments_processed_total"
                        )
                        .description(
                                "Total de pagamentos processados"
                        )
                        .register(registry);

        this.paymentFailedCounter =
                Counter.builder(
                                "payments_failed_total"
                        )
                        .description(
                                "Total de pagamentos com falha"
                        )
                        .register(registry);
    }

    public void incrementProcessed() {
        paymentProcessedCounter.increment();
    }

    public void incrementFailed() {
        paymentFailedCounter.increment();
    }
}