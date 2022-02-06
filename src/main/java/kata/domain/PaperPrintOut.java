package kata.domain;

import java.util.List;

public class PaperPrintOut implements  PrintDevice {

    public void printOut(List<Operation> operations) {

        System.out.println("Printing to paper...");
    }
}
