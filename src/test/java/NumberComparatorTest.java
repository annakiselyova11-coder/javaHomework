import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {
    @Test
    @DisplayName("Числа равны: 5 = 5")
    void testEqual() {
        int n1 = 5;
        int n2 = 5;

        String result = NumberComparator.compareNumbers(n1, n2);
        assertTrue(result.contains("="), "Результат должен содержать '='");
    }

    @Test
    @DisplayName("Первое число больше: 10 > 5")
    void testFirstGreater() {
        int n1 = 10;
        int n2 = 5;

        String result = NumberComparator.compareNumbers(n1, n2);
        assertTrue(result.contains(">"), "Результат должен содержать '>'");
    }

    @Test
    @DisplayName("Второе число больше: 3 < 7")
    void testSecondGreater() {
        int n1 = 3;
        int n2 = 7;

        String result = NumberComparator.compareNumbers(n1, n2);
        assertTrue(result.contains("<"), "Результат должен содержать '<'");
    }


}
