package Lab1;

public class Rectangle
{
    private double height, width;
    private Point base;
    public static int counter = 0;

    public Rectangle (Point base, Point other)
    {
        this(new Point(base.getX(), base.getY()), other.getY()-base.getY(), other.getX()-base.getX());
    }

    public Rectangle (Point base, double height, double width)
    {
        this.base = new Point(base.getX(), base.getY());
        this.height = height;
        this.width = width;
    }

    public Rectangle(double x, double y, double height, double width)
    {
        this(new Point(x,y), height, width);
        this.height = height;
        this.width = width;
        counter ++;
    }

    public double surface ()
    {
        return height * width;
    }

    public double translate ()
    {
        return 2 * (height + width);
    }

    public boolean contains(Point a)
    {
        return a.getY() >= base.getY() && a.getY() <= base.getY() + height &&  a.getX() >= base.getX() && a.getX() <= base.getX() + width;
    }

    public boolean contains(Rectangle a)
    {
        Point topleft = new Point(a.base.getY() + a.height, a.base.getX());
        Point topright = new Point(a.base.getY() + a.height, a.base.getX() + a.width);
        Point bottomright = new Point(a.base.getY(), a.base.getX() + a.width);
        return contains(base) && contains(topleft) && contains(topright) && contains(bottomright);
    }

    public static void main(String[] args) {
        Point base1 = new Point(0, 0);
    }

    private static Point find_lowest_base(Rectangle arr[])
    {
        double minX = arr[0].base.getX();
        double minY = arr[0].base.getY();
        for (Rectangle i : arr) {
            if (i.base.getX() < minX)
                minX = i.base.getX();
            if (i.base.getY() < minY)
                minY = i.base.getY();
        }

        return new Point(minX, minY);
    }

    private static Point find_highest(Rectangle arr[])
    {
        double maxX = arr[0].base.getX();
        double maxY = arr[0].base.getY();
        for (Rectangle i : arr) {
            if (i.base.getX() > maxX)
                maxX= i.base.getX();
            if (i.base.getY() > maxY)
                maxY = i.base.getY();
        }

        return new Point(maxX, maxY);
    }

    public static Rectangle hull (Rectangle arr[])
    {
        Point lowest = find_lowest_base(arr); //synartisi i opoia vriskei ti vasi pou einai pio katw aristera
        Point highest = find_highest(arr); //synartisi i opoia vriskei to pio panw aristera simeio
        return new Rectangle(lowest, highest);
    }
}
