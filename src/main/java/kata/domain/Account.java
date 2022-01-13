package kata.domain;

import java.math.BigDecimal;

public class Account {
	
	private BigDecimal balance;
	
	public Account(BigDecimal init) {
		checkAmount(init);
		this.balance = init;
	}
	
	private void checkAmount(BigDecimal amount) {
		if (amount.doubleValue()< 0) {
			throw new IllegalArgumentException("Amount must be greater than Zero");
		}
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

}
