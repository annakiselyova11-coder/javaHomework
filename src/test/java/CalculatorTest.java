import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Сложение: 10 + 5 = 15")
    void testAddition() {
        int result = Calculator.calculate(10, 5, '+');
        assertEquals(15, result);
    }

    @Test
    @DisplayName("Вычитание: 10 - 5 = 5")
    void testSubtraction() {
        int result = Calculator.calculate(10, 5, '-');
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Умножение: 10 * 5 = 50")
    void testMultiplication() {
        int result = Calculator.calculate(10, 5, '*');
        assertEquals(50, result);
    }

    @Test
    @DisplayName("Деление: 20 / 4 = 5")
    void testDivision() {
        int result = Calculator.calculate(20, 4, '/');
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Деление на ноль вызывает исключение")
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(10, 0, '/'));
    }

    @Test
    @DisplayName("Неверная операция вызывает исключение")
    void testInvalidOperation() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate(5, 3, '%'));
    }

}