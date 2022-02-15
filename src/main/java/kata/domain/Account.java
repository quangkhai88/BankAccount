package kata.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Account {

	private Amount amount;
	
	private final Statement statement = new Statement();

	public Account(Amount amount) {
		this.amount = amount;
	}
	
	public void deposit(Amount amount) {
		this.addToAccount(amount);
		addOperation(amount, OperationType.DEPOSIT);
	}

	public void withdraw(Amount amount) {
		this.checkAmountToWithDraw(amount);
		this.subtract(amount);
		addOperation(amount, OperationType.WITHDRAW);
	}

	private void addOperation(Amount amount, OperationType type) {
		this.statement.addOperation(new Operation(amount.value(), getBalance(), LocalDate.now(), type));
	}

	private void subtract(Amount amount) {
		this.amount = this.amount.subtract(amount);
	}
	private void addToAccount(Amount amount) {
		this.amount = this.amount.add(amount);
	}

	private void checkAmountToWithDraw(Amount amount) {
		if (this.amount.isLessThan(amount)) {
			throw new IllegalArgumentException("Not enough to withdraw");
		}
	}
	
	public BigDecimal getBalance() {
		return amount.value();
	}
	
	public void getHistory() {
	//	this.statement.printStatement();
	}

}
