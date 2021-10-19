package Lab16;

import Lab10.GeometricObject;

public class Square extends GeometricObject implements Colorable{
    private double area, perimeter;
    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
}
