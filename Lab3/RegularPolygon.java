package Lab3;

public class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double XCenter = 0, YCenter = 0;

    public RegularPolygon() {}

    public RegularPolygon(int n, double side)
    {
        this.n = n;
        this.side = side;
    }

    public RegularPolygon(int n, double side, double XCenter, double YCenter)
    {
        this(n, side);
        this.XCenter = XCenter;
        this.YCenter = YCenter;
    }

    public double getPerimeter()
    {
        return side * n;
    }

    public double getArea()
    {
        return n * side * side / (4 * Math.tan((Math.PI) / n));
    }
}
