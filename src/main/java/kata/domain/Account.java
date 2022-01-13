package kata.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {
	
	private BigDecimal balance;
	
	private Statement statement;
	
	public Account(BigDecimal init) {
		this.checkAmount(init);
		this.balance = init;
		this.statement = new Statement();
	}
	
	public void deposit(BigDecimal amount) {
		this.checkAmount(amount);
		this.addToAccount(amount);
		this.statement.addOperation(new Operation(amount, balance, LocalDate.now(), OperationType.DEPOSIT));
	}
	
	public void withdraw(BigDecimal amount) {
		this.checkAmount(amount);
		amount = new BigDecimal(0).subtract(amount);
		this.addToAccount(amount);
		this.statement.addOperation(new Operation(amount, balance, LocalDate.now(), OperationType.WITHDRAW));
	}
	
	private void addToAccount(BigDecimal amount) {
		this.balance = this.balance.add(amount);
	}

	private void checkAmount(BigDecimal amount) {
		if (amount == null || amount.doubleValue()< 0) {
			throw new IllegalArgumentException("Amount must be not null and greater than Zero");
		}
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

}
