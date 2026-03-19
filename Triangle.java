public class Triangle implements Shape {

    private double a,b,c;
    private String fillColor;
    private String borderColor;

    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        this.a = a;
        this.b = b;
        this.c = c;
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
    public double getArea() {  // Формула Герона: S = √(p * (p - a) * (p - b) * (p - c)), p — полупериметр, a, b, c — длины сторон треугольника
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double getPerimeter() {  // Периметр: сумма всех сторон
        return a + b + c;
    }
}
