package org.processor.domain.model;

import java.math.BigDecimal;

public class Account {

    private String id;

    private BigDecimal balance;

    public Account() {
    }

    public Account(
            String id,
            BigDecimal balance
    ) {
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void debit(
            BigDecimal amount
    ) {

        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException(
                    "Saldo insuficiente"
            );
        }

        balance = balance.subtract(
                amount
        );
    }

    public void credit(
            BigDecimal amount
    ) {

        balance = balance.add(
                amount
        );
    }
}