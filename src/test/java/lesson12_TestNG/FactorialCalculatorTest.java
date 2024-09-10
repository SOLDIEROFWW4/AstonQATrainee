package lesson12_TestNG;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.astondev.lesson12.FactorialCalculator;
import ru.astondev.lesson12.RecursiveFactorialCalculator;

public class FactorialCalculatorTest {

    private FactorialCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new RecursiveFactorialCalculator();
    }

    @Test
    public void testFactorialOfZero() {
        long result = calculator.calculate(0);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testFactorialOfOne() {
        long result = calculator.calculate(1);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void testFactorialOfFive() {
        long result = calculator.calculate(5);
        Assert.assertEquals(result, 120);
    }

    @Test
    public void testFactorialOfTen() {
        long result = calculator.calculate(10);
        Assert.assertEquals(result, 3628800);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        calculator.calculate(-1);
    }
}
