public class Circle extends Shape {
    private double radius;


    public Circle() {
        this.radius = 1.0;
    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        double pi = 3.14;
        return pi * getRadius() * 2;
    }
    public double getPerimeter() {
        double pi = 3.14;
        return pi * (radius * radius);
    }

    @Override
    public String toString() {
        return "Circle { " +
                "radius=" + radius +
                '}';
    }
}
