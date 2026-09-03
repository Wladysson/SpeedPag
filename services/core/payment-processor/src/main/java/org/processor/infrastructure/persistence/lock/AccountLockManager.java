package org.processor.infrastructure.persistence.lock;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;

import org.processor.infrastructure.persistence.entity.AccountEntity;

@ApplicationScoped
public class AccountLockManager {

    private final EntityManager entityManager;

    public AccountLockManager(
            EntityManager entityManager
    ) {
        this.entityManager =
                entityManager;
    }

    public AccountEntity lockAccount(
            String accountId
    ) {

        return entityManager.find(
                AccountEntity.class,
                accountId,
                LockModeType.PESSIMISTIC_WRITE
        );
    }
}