import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaCalculatorTest {

    @Test(description = "Площадь (10, 5) = 25.0")
    public void testNormalCase() {
        double result = TriangleAreaCalculator.getArea(10, 5);
        assertEquals(result, 25.0, 0.01);
    }

    @Test(description = "Отрицательное основание вызывает исключение",
            expectedExceptions = IllegalArgumentException.class)
    public void testNegativeBase() {
        TriangleAreaCalculator.getArea(-5, 10);
    }
}