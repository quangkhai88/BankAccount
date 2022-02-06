package kata.domain;

import java.util.ArrayList;
import java.util.List;

public class Statement {
	
	private List<Operation> operations;
	
	
	public Statement() {
		this.operations = new ArrayList<Operation>();
	}
	
	public void addOperation(Operation operation) {
		this.operations.add(operation);
	}
	
	public String getPrintStatement() {
		StringBuilder sb = new StringBuilder("Operation | Date | Amount | Balance").append("\n");
		for (Operation operation: this.operations) {
			sb.append(operation.toString()).append("\n");
		}
		return sb.toString();
	}
	
	public void printStatement(PrintDevice printDevice) {
		printDevice.printOut(operations);
	}
	
}
