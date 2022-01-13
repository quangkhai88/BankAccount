package kata.domain;

import java.math.BigDecimal;

public class Account {
	
	private BigDecimal balance;
	
	public Account(BigDecimal init) {
		this.checkAmount(init);
		this.balance = init;
	}
	
	public void deposit(BigDecimal amount) {
		this.checkAmount(amount);
		this.addToAccount(amount);
	}
	
	public void withdraw(BigDecimal amount) {
		this.checkAmount(amount);
		amount = new BigDecimal(0).subtract(amount);
		this.addToAccount(amount);
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
