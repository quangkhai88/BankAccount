package tradingRoom;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public final class Operation {

    private OperationType operationType;

    private BigDecimal value;

}
