package kata.domain;


import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class StatementTest {

private Statement statement;
	
	@Before
	public void init() {
		this.statement = new Statement();
	}
	
	@Test
	public void no_operation_test() {
		assertTrue(this.statement.getPrintStatement().equals("Operation | Date | Amount | Balance\n"));
	}
	
	@Test
	public void add_operation_test() {
		this.statement.addOperation(new Operation(new BigDecimal(30), new BigDecimal(100), LocalDate.of(2022, 1, 1), OperationType.DEPOSIT));
		
		String expected = "Operation | Date | Amount | Balance\n" + 
						  "DEPOSIT | 2022-01-01 | 30 | 100\n";
		assertTrue(this.statement.getPrintStatement().equals(expected));
	}
}
