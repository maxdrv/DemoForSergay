package org.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteFromArrayTest {

    @Test
    void mathIsOk() {
        int i = 2 + 2;
        Assertions.assertEquals(4, i);
    }

    @Test
    void removeElement() {
        String[] array = new String[]{"a", "b", "c"};

        String[] actual = DeleteFromArray.delete(array, 0);

        Assertions.assertArrayEquals(new String[]{"b", "c"}, actual);
    }

    @Test
    void removeElementAtNegativeIndex() {
        String[] array = new String[]{"a", "b", "c"};

        String[] actual = DeleteFromArray.delete(array, -1);

        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, actual);
    }

    @Test
    void nonExistentIndex() {
        String[] array = new String[]{"a", "b", "c"};

        String[] actual = DeleteFromArray.delete(array, 100);

        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, actual);
    }

    @Test
    void indexAtTheEndOfArray() {
        String[] array = new String[]{"a", "b", "c"};

        String[] actual = DeleteFromArray.delete(array, 3);

        Assertions.assertArrayEquals(new String[]{"a", "b", "c"}, actual);
    }

}
