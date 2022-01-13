package kata.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Operation {
	
	private BigDecimal amount;
	
	private BigDecimal balance;
	
	private LocalDate date;
	
	private OperationType type;
	

	public Operation(BigDecimal amount, BigDecimal balance, LocalDate date, OperationType type) {
		super();
		this.amount = amount;
		this.balance = balance;
		this.date = date;
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}


	public LocalDate getDate() {
		return date;
	}

	public OperationType getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return type.toString() + " | "  + 
				date.format(DateTimeFormatter.ISO_DATE) +  " | " +
				amount.longValue() + " | " +
				balance.longValue();
	}


	
}
