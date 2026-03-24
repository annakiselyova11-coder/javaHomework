import java.util.Scanner;

public class NumberComparator {
    public static String compareNumbers(int n1, int n2) {
        if (n1 == n2) {
            return n1 + " = " + n2;
        } else if (n1 < n2) {
            return n1 + " < " + n2;
        } else {
            return n1 + " > " + n2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сравнение двух чисел: ");

        System.out.println("Введите первое число: ");
        int n1 = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int n2 = scanner.nextInt();

        String result = compareNumbers(n1, n2);
        System.out.println(result);

        scanner.close();
    }
}

