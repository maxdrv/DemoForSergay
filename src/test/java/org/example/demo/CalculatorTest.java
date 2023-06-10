package org.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void add() {
        Calculator calculator = new DummyCalculator();

        double result = calculator.calculate("1+1");
        Assertions.assertEquals(2, result);
    }

    @Test
    void sub() {
        Calculator calculator = new DummyCalculator();

        double result = calculator.calculate("10-2");
        Assertions.assertEquals(8, result);
    }


}
