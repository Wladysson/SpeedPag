package org.handler.infrastructure.observability;

import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.UUID;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class RequestTracingFilter
        implements ContainerRequestFilter {

    public static final String
            CORRELATION_ID_HEADER =
            "X-Correlation-Id";

    @Override
    public void filter(
            ContainerRequestContext requestContext
    ) throws IOException {

        String correlationId =
                requestContext.getHeaderString(
                        CORRELATION_ID_HEADER
                );

        if (correlationId == null
                || correlationId.isBlank()) {

            correlationId =
                    UUID.randomUUID()
                            .toString();
        }

        requestContext.setProperty(
                CORRELATION_ID_HEADER,
                correlationId
        );
    }
}