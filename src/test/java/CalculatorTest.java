import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CalculatorTest {

    @Test(description = "Сложение: 10 + 5 = 15")
    public void testAddition() {
        int result = Calculator.calculate(10, 5, '+');
        assertEquals(result, 15);
    }

    @Test(description = "Вычитание: 10 - 5 = 5")
    public void testSubtraction() {
        int result = Calculator.calculate(10, 5, '-');
        assertEquals(result, 5);
    }

    @Test(description = "Умножение: 10 * 5 = 50")
    public void testMultiplication() {
        int result = Calculator.calculate(10, 5, '*');
        assertEquals(result, 50);
    }

    @Test(description = "Деление: 20 / 4 = 5")
    public void testDivision() {
        int result = Calculator.calculate(20, 4, '/');
        assertEquals(result, 5);
    }

    @Test(description = "Деление на ноль вызывает исключение",
            expectedExceptions = IllegalArgumentException.class)
    public void testDivisionByZero() {
        Calculator.calculate(10, 0, '/');
    }

    @Test(description = "Неверная операция вызывает исключение",
            expectedExceptions = IllegalArgumentException.class)
    public void testInvalidOperation() {
        Calculator.calculate(5, 3, '%');
    }
}