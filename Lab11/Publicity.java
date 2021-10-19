package Lab11;

public class Publicity extends Mail{

    public Publicity(int weight, boolean express, String address) {
        super(weight, express, address);
    }

    public double normalPostageRate()
    {
        return getWeight() * 5;
    }

    @Override
	public String toString()
    {
		String s = "Publicity\n";
		s += super.toString();
		return s;
	}

}
