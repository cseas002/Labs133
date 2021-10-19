package Lab4;

import Lab1.Point;

public class Triangle2D {
    private Point p1, p2, p3;
    public Triangle2D(Point p1, Point p2, Point p3)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    private double sign(Point point1, Point point2, Point point3)
    {
        return (point1.getX() - point3.getX()) * (point2.getY() - point3.getY()) - (point2.getY() - point3.getY()) * (point1.getY() - point3.getY());
    }

    public boolean contains (Point pt)
    {
        double d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(pt, p1, p2);
        d2 = sign(pt, p2, p3);
        d3 = sign(pt, p3, p1);

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }

    public boolean contains(Triangle2D triangle)
    {
        return contains(triangle.p1) && contains(triangle.p2) && contains(triangle.p3);
    }

    public boolean overlaps(Triangle2D triangle)
    {
        return (contains(triangle.p1) || contains(triangle.p2) || contains(triangle.p3)) && !contains(triangle);
    }
}
