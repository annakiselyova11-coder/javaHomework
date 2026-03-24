import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FactorialTest {

    @Test(description = "Факториал 5 = 120")
    public void testFactorial5() {
        long result = Factorial.getFactorial(5);
        assertEquals(result, 120);
    }

    @Test(description = "Факториал 0 = 1")
    public void testFactorial0() {
        long result = Factorial.getFactorial(0);
        assertEquals(result, 1);
    }

    @Test(description = "Отрицательное число вызывает исключение",
            expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumber() {
        Factorial.getFactorial(-5);
    }
}