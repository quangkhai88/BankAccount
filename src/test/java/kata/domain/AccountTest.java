package kata.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	private Account account;
	
	@Before
	public void init() {
		this.account = new Account(Amount.of(new BigDecimal(100)));
	}
	
	@Test
	public void initAccountWithCorrectAmountValue() {
		//Given
		//When
		BigDecimal balance = this.account.getBalance();
		//Then
		assertEquals(balance, new BigDecimal(100));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void depositInvalidAmountAndGetException() {
		//When
		this.account.deposit(Amount.of(new BigDecimal(-10)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void depositNullValueAndGetException() {
		//When
		this.account.deposit(null);
	}
	
	@Test
	public void depositWithCorrectAmountValue() {
		//Given
		this.account.deposit(Amount.of(new BigDecimal(50)));
		//When
		BigDecimal balance = this.account.getBalance();
		//Then
		assertEquals(balance, new BigDecimal(150));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void withdrawInvalidAmountAndGetException() {
		//When
		this.account.withdraw(Amount.of(new BigDecimal(-10)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void withdrawNullValueAndGetException() {
		//When
		this.account.withdraw(null);
	}
	
	@Test
	public void withdrawWithCorrectAmountValue() {
		//Given
		this.account.withdraw(Amount.of(new BigDecimal(40)));
		//When
		BigDecimal balance = this.account.getBalance();
		//Then
		assertEquals(balance, new BigDecimal(60));
	}
	
	@Test
	public void printAllOperationHistory() {
		this.account.deposit(Amount.of(new BigDecimal(100)));
		this.account.withdraw(Amount.of(new BigDecimal(30)));
		
		this.account.getHistory();
	}
	
}
