import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleAreaCalculatorTest {

    @Test
    @DisplayName("Площадь (10, 5) = 25.0")
    void testNormal() {
        double result = TriangleAreaCalculator.getArea(10, 5);
        assertEquals(25.0, result, 0.01);
    }

    @Test
    @DisplayName("Площадь с дробными значениями (3.5, 4) = 7.0")
    void testDecimal() {
        double result = TriangleAreaCalculator.getArea(3.5, 4);
        assertEquals(7.0, result, 0.01);
    }

    @Test
    @DisplayName("Отрицательное основание вызывает исключение")
    void testNegativeBase() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.getArea(-5, 10));
    }

    @Test
    @DisplayName("Отрицательная высота вызывает исключение")
    void testNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.getArea(10, -5));
    }

    @Test
    @DisplayName("Ноль вызывает исключение")
    void testZero() {
        assertThrows(IllegalArgumentException.class, () -> TriangleAreaCalculator.getArea(0, 5));
    }
}