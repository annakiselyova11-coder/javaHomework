public interface Shape {

    String getFillColor();
    String getBorderColor();

    double getArea();
    double getPerimeter();

    default void printInfo() {
        System.out.println("Площадь: " + getArea());
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
    }


}
