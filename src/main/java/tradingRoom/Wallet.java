package tradingRoom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Wallet {

    private final List<Operation> operations = new ArrayList<>();

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    public BigDecimal getValue() {
        return operations.stream().map(Operation::getValue).reduce(new BigDecimal(0), BigDecimal::add);
    }
}
