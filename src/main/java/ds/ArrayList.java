package ds;

import java.util.Arrays;

/**
 * @author Quang-Khai TRAN
 * @date 14/02/2022
 */

public class ArrayList {

    private static final int DEFAULT_ARRAY_SIZE = 10;

    private Object[] elements = new Object[DEFAULT_ARRAY_SIZE];

    int size = 0;

    public void add(Object e) {
        checkElementsSize();
        elements[size++] = e;
    }

    private void checkElementsSize() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length + DEFAULT_ARRAY_SIZE);
        }
    }

    public Object get(int i) {
        if (i >= 0 && i < size) {
            return elements[i];
        }
        throw new RuntimeException("ArrayIndexOutOfBound");
    }

    public int size() {
        return size;
    }
}
