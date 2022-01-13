package kata.domain;

import java.util.ArrayList;
import java.util.List;

public class Statement {
	
	private List<Operation> listOperations;
	
	public Statement() {
		this.listOperations  = new ArrayList<Operation>();
	}
	
	public void addOperation(Operation operation) {
		this.listOperations.add(operation);
	}
	
	public String getPrintStatement() {
		StringBuilder sb = new StringBuilder("Operation | Date | Amount | Balance").append("\n");
		for (Operation operation: this.listOperations) {
			sb.append(operation.toString()).append("\n");
		}
		return sb.toString();
	}
	
	public void printStatement() {
		System.out.println(getPrintStatement());
	}
	
}
