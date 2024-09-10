package lesson12_JUnit_5;

import org.junit.jupiter.api.*;
import ru.astondev.lesson12.FactorialCalculator;
import ru.astondev.lesson12.RecursiveFactorialCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new RecursiveFactorialCalculator();
    }

    @Test
    void testFactorialOfZero() {
        long result = calculator.calculate(0);
        assertEquals(1, result);
    }

    @Test
    void testFactorialOfOne() {
        long result = calculator.calculate(1);
        assertEquals(1, result);
    }

    @Test
    void testFactorialOfFive() {
        long result = calculator.calculate(5);
        assertEquals(120, result);
    }

    @Test
    void testFactorialOfTen() {
        long result = calculator.calculate(10);
        assertEquals(3628800, result);
    }

    @Test
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-1));
    }
}
