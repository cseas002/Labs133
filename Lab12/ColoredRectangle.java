package Lab12;

import java.awt.*;
import java.util.Objects;

public class ColoredRectangle extends Rectangle{
    private String color;
    public ColoredRectangle (Point base, Point other, String color)
    {
        super(base, other);
        this.color = color;
    }

    public ColoredRectangle (Point base, double height, double width, String color)
    {
        super(base, height, width);
        this.color = color;
    }

    public ColoredRectangle(double x, double y, double height, double width, String color)
    {
        super(x, y, height, width);
        this.color = color;
    }

    public ColoredRectangle(double height, double width, String color)
    {
        super(height, width);
        this.color = color;
    }

    public String toString()
    {
        String str = super.toString();
        str += "\tcolor : " + color;
        return str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}
