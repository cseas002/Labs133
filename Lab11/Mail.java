package Lab11;

public abstract class Mail {
    private int weight;
    private boolean express;
    private String address;

    public Mail() {
    }

    public Mail(int weight, boolean express, String address) {
        this.weight = weight;
        this.express = express;
        this.address = address;
    }

    public boolean isExpress() {
        return express;
    }

    public String getAddress() {
        return address;
    }

    public int getWeight() {
        return weight;
    }

    public double postageRate()
    {
        if (!valid())
            return 0;

        double total = normalPostageRate();

        if (express)
            total *= 2;

        return total;
    }

    public abstract double normalPostageRate();

    public String toString()
    {
        String str = "";
        if (!valid())
            str += "(Mail  invalid)\n";
        str += "	Weight : " + weight + " grammes\n";
        str += "	Express : " + (express ? "yes" : "no") + "\n";
        str += "	Destination : " + address + "\n";
        str += "	Price : " + postageRate() + " Euro\n";
        return str;

    }

    public boolean valid()
    {
        return address.length() > 0;
    }
}
