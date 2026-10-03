package org.handler.domain.model;

import java.util.Objects;

public class AccountId {

    private final String value;

    public AccountId(String value) {

        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "AccountId invalido"
            );
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof AccountId that)) {
            return false;
        }

        return Objects.equals(
                value,
                that.value
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}