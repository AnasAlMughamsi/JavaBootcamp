public class Main {
    public static void main(String[] args) {

        System.out.println("=============================== Rectangle ===============================");
        Rectangle rectangle = new Rectangle();
        rectangle.setColor("red");
        rectangle.setFilled(false);
        rectangle.setWidth(3);
        rectangle.setLength(5);
        System.out.println("Color of rectangle: " + rectangle.getColor());
        System.out.println("Is rectangle filled ? : " + rectangle.isFilled());
        System.out.println("Width: " + rectangle.getWidth() + " Length: " + rectangle.getLength());
        System.out.println("The area of the rectangle: " + rectangle.getArea());
        System.out.println("The perimeter of the rectangle: " + rectangle.getPerimeter());


        System.out.println("=============================== Square ===============================");

        Square square = new Square();
        square.setSide(7);
        System.out.println("Side of square: " + square.getSide());
        System.out.println("Area of square: " + square.getArea());
        System.out.println("Perimeter of square: " + square.getPerimeter());


        System.out.println("=============================== Circle ===============================");
        Circle circle = new Circle();
        circle.setColor("Blue");
        circle.setFilled(true);
        circle.setRadius(3);
        System.out.println("Color of circle " + circle.getColor());
        System.out.println("Is circle filled ? " + circle.isFilled());
        System.out.println("radius of circle: " + circle.getRadius());
        System.out.println("Area of circle: " + circle.getArea());
        System.out.println("Perimeter of circle: " + circle.getPerimeter());



    }
}