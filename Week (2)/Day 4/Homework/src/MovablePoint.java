public class MovablePoint implements Movable {
    private int x;
    private int xSpeed;
    private int y;
    private int ySpeed;

    public MovablePoint(int x, int xSpeed, int y, int ySpeed) {
        this.x = x;
        this.xSpeed = xSpeed;
        this.y = y;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        System.out.println(y += ySpeed);
    }

    @Override
    public void moveDown() {
        System.out.println(y -= ySpeed);
    }

    @Override
    public void moveRight() {
        System.out.println(x += xSpeed);
    }

    @Override
    public void moveLeft() {
        System.out.println(x -= xSpeed);
    }
}
