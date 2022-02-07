package kata.domain;

import java.math.BigDecimal;

public final class Amount {

    private final BigDecimal amount;

    public Amount(BigDecimal amount) {
        if (amount == null || amount.doubleValue() < 0)
            throw new IllegalArgumentException("Invalid value");
        this.amount = amount;
    }

    public BigDecimal value(){
        return this.amount;
    }


}
