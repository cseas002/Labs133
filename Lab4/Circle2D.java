package Lab4;

public class Circle2D {
    private double x = 0, y = 0, radius = 1;

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getRadius()
    {
        return radius;
    }

    public Circle2D() {}


    public Circle2D(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea()
    {
        return Math.PI * radius * radius;
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    private double distance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public boolean contains(double x, double y)
    {
        return distance(x, y, this.x, this.y) < radius;
    }

    public boolean contains(Circle2D circle)
    {
        return distance(this.x, this.y, circle.getX(), circle.getY()) < radius - circle.radius;
    }

    public boolean overlaps(Circle2D circle)
    {
        return distance(this.x, this.y, circle.getX(), circle.getY()) < Math.abs(this.radius + circle.getRadius()) && !contains(circle) && !circle.contains(this);
    }
}
