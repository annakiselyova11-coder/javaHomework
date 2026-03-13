public class Rectangle implements Shape {

    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
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
    public double getArea() {   // Формула площади: ширина * высота
        return width * height;
    }

    @Override
    public double getPerimeter() { // Формула периметра: 2 * (ширина + высота)
        return 2 * (width + height);
    }
}
