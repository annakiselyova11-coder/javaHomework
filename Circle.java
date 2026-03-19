public class Circle implements Shape {

    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius; // Площадь круга: π * r²
    }

    @Override
    public double getPerimeter() { // Длина окружности: 2 * π * r
        return 2 * Math.PI * radius;
    }
}
