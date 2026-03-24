import java.util.Scanner;

public class Calculator {
    public static int calculate(int n1, int n2, char operation) {
        switch (operation) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            case '/':
                if (n2 == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно!");
                }
                return n1 / n2;
            default:
                throw new IllegalArgumentException("Неверная операция: " + operation);
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Калькулятор.");

        System.out.print("Введите первое число: ");
        int n1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int n2 = scanner.nextInt();

        System.out.print("Введите операцию ( +, -, *, /): ");
        char operation = scanner.next().charAt(0);

        try {
            int result = calculate(n1, n2, operation);
            System.out.println("Результат: " + n1 + " " + operation + " " + n2 + " = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        scanner.close();
    }
}
