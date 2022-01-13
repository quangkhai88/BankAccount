package kata.domain;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	private Account account;
	
	@Before
	public void init() {
		this.account = new Account(new BigDecimal(100));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void initAccountWithNegativeAmountThenGetException() {
		//Given
		//When
		this.account = new Account(new BigDecimal(-100));
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
		this.account.deposit(new BigDecimal(-10));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void depositNullValueAndGetException() {
		//When
		this.account.deposit(null);
	}
	
	@Test
	public void depositWithCorrectAmountValue() {
		//Given
		this.account.deposit(new BigDecimal(50));
		//When
		BigDecimal balance = this.account.getBalance();
		//Then
		assertEquals(balance, new BigDecimal(150));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void withdrawInvalidAmountAndGetException() {
		//When
		this.account.withdraw(new BigDecimal(-10));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void withdrawNullValueAndGetException() {
		//When
		this.account.withdraw(null);
	}
	
	@Test
	public void withdrawWithCorrectAmountValue() {
		//Given
		this.account.withdraw(new BigDecimal(40));
		//When
		BigDecimal balance = this.account.getBalance();
		//Then
		assertEquals(balance, new BigDecimal(60));
	}
	
}
