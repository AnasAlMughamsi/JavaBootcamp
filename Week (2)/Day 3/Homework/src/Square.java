public class Square extends Rectangle {

    public Square() {
    }

    public Square(double width, double length) {
        super(width, length);
    }

    public Square(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    // you need to check with this set method !
    // Is it correct to insert width argument inside this.setWidth() ?
    public void setSide(double width) {
        this.setWidth(width);
    }
    public double getSide() {
        return getWidth();
    }
    @Override
    public double getArea() {
        return this.getWidth() * this.getWidth();
    }

    @Override
    public double getPerimeter() {
        return this.getWidth() * 4;
    }

    @Override
    public String toString() {
        return "Square { " + "side = " + getWidth() + " }";
    }
}
