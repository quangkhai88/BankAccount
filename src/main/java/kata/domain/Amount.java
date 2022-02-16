package kata.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class Amount {

    private final BigDecimal amount;

    private enum AmountOperator {
        ADD, SUBTRACT;
    }

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

    private  Amount operate(Amount amount, AmountOperator operator) {
        if (amount == null || operator == null) throw new IllegalArgumentException("Not null please");
        switch (operator) {
            case ADD:
                return new Amount(this.value().add(amount.value()));
            case SUBTRACT:
                return new Amount(this.value().subtract(amount.value()));
        }
        return this;
    }

    public Amount add(Amount amountToAdd) {
        return this.operate(amountToAdd, AmountOperator.ADD);
    }

    public Amount subtract(Amount amountToSub) {
        return this.operate(amountToSub, AmountOperator.SUBTRACT);
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
