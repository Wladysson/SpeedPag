package org.handler.infrastructure.persistence.migration;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersistenceMigrationConfig {

    public String version() {
        return "v1";
    }
}