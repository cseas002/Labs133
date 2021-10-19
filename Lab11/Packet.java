package Lab11;

public class Packet extends Mail{
    private double volume;

    public Packet(int weight, boolean express, String address, double volume)
    {
        super(weight, express, address);
        this.volume = volume;
    }

    public double normalPostageRate()
    {
        return 0.25 * volume + getWeight() / 1000.0;
    }

    public boolean valid()
    {
        return super.valid() && volume <= 50;
    }

    public String toString()
    {
		String s = "Packet\n";
		s += super.toString();
		s += "	Volume : " + volume + " litres\n";
		return s;
	}
}
