package org.processor.infrastructure.persistence.repository;

import jakarta.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import org.processor.infrastructure.persistence.entity.AccountEntity;

import java.util.Optional;

@ApplicationScoped
public class AccountRepository
        implements PanacheRepository<AccountEntity> {

    public Optional<AccountEntity> findByAccountId(
            String accountId
    ) {

        return find(
                "id",
                accountId
        ).firstResultOptional();
    }

    public void updateBalance(
            AccountEntity account
    ) {

        persist(account);
    }
}