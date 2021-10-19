package Lab1;

public class Sxima {
    private Rectangle[] arr;

    public Sxima(Rectangle[] arr) {
        this.arr = new Rectangle[arr.length];
        for (int i = 0; i < arr.length; i++)
            this.arr[i] = arr[i];
    }

    public void add(Rectangle a)
    {
        Rectangle[] temp = new Rectangle[arr.length + 1];
        for (int i = 0; i < arr.length; i++)
            temp[i] = arr[i];

        temp[arr.length] = a;
        arr = temp;
    }

    public double surface()
    {
        double surf = 0;
        for (Rectangle rectangle : arr)
            surf += rectangle.surface();

        return surf;
    }

    public double translate()
    {
        double tran = 0;
        for (Rectangle rectangle : arr)
            tran += rectangle.surface();

        return tran;
    }

    public Rectangle hull()
    {
        return Rectangle.hull(arr);
    }
}
