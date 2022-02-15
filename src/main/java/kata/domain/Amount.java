package kata.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Amount {

    private final BigDecimal amount;

    private Amount(BigDecimal amount) {
        if (amount == null || amount.doubleValue() < 0)
            throw new IllegalArgumentException("Invalid value");
        this.amount = amount;
    }

    public static Amount of(BigDecimal value) {
        return new Amount(value);
    }

    public BigDecimal value(){
        return this.amount;
    }

    public Amount add(Amount amountToAdd) {
        if (amountToAdd == null) throw new IllegalArgumentException("Not null please");
        return new Amount(this.value().add(amountToAdd.value()));
    }

    public Amount subtract(Amount amountToSub) {
        if (amountToSub == null) throw new IllegalArgumentException("Not null please");
        return new Amount(this.value().subtract(amountToSub.value()));
    }

    public boolean isGreaterThan(Amount amount) {
        return this.compare(amount) > 0;
    }

    public boolean isLessThan(Amount amount) {
        return this.compare(amount) < 0;
    }

    private int compare(Amount amount) {
        if (amount == null) throw new IllegalArgumentException("Not null please");
        return this.value().compareTo(amount.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return amount.compareTo(amount1.value()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
