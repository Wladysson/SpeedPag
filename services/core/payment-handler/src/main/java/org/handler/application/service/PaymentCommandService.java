package org.handler.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import org.handler.domain.model.Payment;
import org.handler.infrastructure.messaging.KafkaPaymentProducer;
import org.handler.infrastructure.persistence.repository.PaymentRepository;

@ApplicationScoped
public class PaymentCommandService {

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    KafkaPaymentProducer kafkaPaymentProducer;

    @Transactional
    public Payment create(Payment payment) {

        paymentRepository.persist(payment);

        kafkaPaymentProducer.publish(payment);

        return payment;
    }
}