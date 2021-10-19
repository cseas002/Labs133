package Lab11;

public class Letter extends Mail{

    private String format;
    public Letter(int weight, boolean express, String address, String format)
    {
        super(weight, express, address);
        this.format = format;
    }

    public double normalPostageRate()
    {
    double price;
    if (format.equals("A4"))
        price = 2.5;
    else
        price = 3.5;

    price += (double) getWeight() / 1000;

    return price;
    }

    public String toString()
    {
        String str = super.toString();
        str += "Letter\n";
        str += "	Format : " + format + "\n";
        return str;
    }

}
