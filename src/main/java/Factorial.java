import java.util.Scanner;

public class Factorial {
    public static long getFactorial(long n) {

        if (n < 0) {
            throw new IllegalArgumentException("Факториал не определен для отрицательных чисел: " + n);
        }

        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число: ");
        long number = scanner.nextLong();

        try {
            long result = getFactorial(number);
            System.out.println(number + "! = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }
}
