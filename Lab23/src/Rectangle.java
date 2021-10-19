
public class Rectangle {
    private double x = 1, y = 1, width = 1, height = 1;

    public Rectangle() {
    }

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPerimeter() {
        return (height + width) * 2;
    }

    public double getArea() {
        return height * width;
    }

    public boolean contains(double x, double y) {
        return Math.abs(this.x - x) <= width / 2 && Math.abs(this.y - y) <= height / 2;
    }

    public boolean contains(Rectangle other) {
        boolean topleft = contains(other.getX() - other.getWidth() / 2, other.getY() + other.getHeight() / 2);
        boolean topright = contains(other.getX() + other.getWidth() / 2, other.getY() + other.getHeight() / 2);
        boolean bottomleft = contains(other.getX() - other.getWidth() / 2, other.getY() - other.getHeight() / 2);
        boolean bottomright = contains(other.getX() + other.getWidth() / 2, other.getY() - other.getHeight() / 2);

        return topleft && topright && bottomleft && bottomright;
    }

    public boolean overlaps(Rectangle other) {
        boolean topleft = other.contains(this.getX() - this.getWidth() / 2, this.getY() + this.getHeight() / 2);
        boolean topright = other.contains(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
        boolean bottomleft = other.contains(this.getX() - this.getWidth() / 2, this.getY() - this.getHeight() / 2);
        boolean bottomright = other.contains(this.getX() + this.getWidth() / 2, this.getY() - this.getHeight() / 2);

        return topleft && topright && bottomleft && bottomright;
    }

    public static void main(String[] args)
    {
        Rectangle rec1 = new Rectangle();
        Rectangle rec2 = new Rectangle(1, 1, 2, 2);

        StdOut.println(rec1.contains(rec2));
        StdOut.println(rec1.overlaps(rec2));
        StdOut.println(rec1.getArea());
        StdOut.println(rec1.getPerimeter());
    }
}
