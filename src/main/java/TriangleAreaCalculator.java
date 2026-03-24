import java.util.Scanner;

public class TriangleAreaCalculator {

    public static double getArea(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Основание и высота должны быть положительными числами!");
        }
        double area = 0.5 * base * height;
        return area;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Вычисление площади треугольника.");
        System.out.println("Введите длину основания: ");
        double base = scanner.nextDouble();

        System.out.println("Введите высоту треугольника: ");
        double height = scanner.nextDouble();

        try {
            double result = getArea(base, height);
            System.out.printf("Площадь треугольника равна: %.2f%n", result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        scanner.close();
    }

}
