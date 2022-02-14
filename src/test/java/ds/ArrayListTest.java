package ds;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ArrayListTest {

    @Test
    public void add() {

        ArrayList myList = new ArrayList();

        Assertions.assertThat(myList.size()).isEqualTo(0);
        for (int i = 0; i <100; i++) {
            myList.add(i);
        }

        Assertions.assertThat(myList.size()).isEqualTo(100);

        for (int i = 0; i <100; i++) {
            Assertions.assertThat(myList.get(i)).isEqualTo(i);
        }

    }

}