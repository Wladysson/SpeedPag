package org.processor.domain.exception;

public class SagaCompensationException
        extends RuntimeException {

    public SagaCompensationException(
            String message
    ) {
        super(message);
    }
}