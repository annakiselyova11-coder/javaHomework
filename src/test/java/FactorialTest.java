import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    @DisplayName("Факториал 5 = 120")
    void testFactorial5() {
        int input = 5;
        long expected = 120;

        long result = Factorial.getFactorial(input);

        assertEquals(120,result,"Факториал 5 должен быть 120");
    }

    @Test
    @DisplayName("Факториал 0 = 1")
    void testFactorial0() {
        int input = 0;
        long expected = 1;

        long result = Factorial.getFactorial(input);

        assertEquals(1,result, "Факториал 0 должен быть 1");
    }

    @Test
    @DisplayName("Отрицательное число вызывает исключение")
    void testFactorialNegativeNumber(){
        int input = -5;

        assertThrows(IllegalArgumentException.class,() -> Factorial.getFactorial(input));
    }
}