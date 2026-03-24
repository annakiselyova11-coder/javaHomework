import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTest {

    @Test(description = "Числа равны: 5 = 5")
    public void testEqual() {
        String result = NumberComparator.compareNumbers(5, 5);
        assertTrue(result.contains("="), "Результат должен содержать '='");
    }

    @Test(description = "Первое число больше: 10 > 5")
    public void testFirstGreater() {
        String result = NumberComparator.compareNumbers(10, 5);
        assertTrue(result.contains(">"), "Результат должен содержать '>'");
    }
}