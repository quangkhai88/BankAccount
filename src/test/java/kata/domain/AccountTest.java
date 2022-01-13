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
	
}
