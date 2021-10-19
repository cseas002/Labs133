package Lab1;

/**
 * @author Christoforos Seas
 * @version 14.0.2
 * {@link Rectangle}
 */

public class Rational {
    private int numerator = 0;
    private int denominator = 1;

    public Rational() {}

    /**
     *
     * @param numerator
     * @param denominator
     */
    public Rational (int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private void simplify() {
// Determine if the rational is positive or negative
        int sign = 1;
        if (numerator * denominator < 0)
            sign = -1;

        int n = Math.abs(numerator);
        int d = Math.abs(denominator);
        int common = getGCD(n, d);

// guarantee that the denominator is positive
        numerator = sign * n / common;
        denominator = d / common;
    }


    /**
     *
     * @param n an integer
     * @param m an integer
     * @return gcd
     */
    private static int getGCD(int n, int m) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            if ((n % i == 0) && (m % i == 0))
                result = i;
        }

        return result;
    }

    public float getValue()
    {
        return ((float)numerator / (float) denominator);
    }

    public String toString()
    {
        return numerator + " / " + denominator;
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public Rational add(Rational b)
    {
        return new Rational(this.getNumerator() * b.denominator + b.numerator * this.getDenominator(), this.getDenominator() * b.getDenominator());
    }

    public Rational subtract(Rational b)
    {
        return new Rational(this.getNumerator() * b.getDenominator() - b.getNumerator() * this.getDenominator(), this.getDenominator() * b.getDenominator());
    }

    public Rational multiply(Rational b)
    {
        return new Rational(this.getNumerator() * b.getNumerator(), this.getDenominator() * b.getDenominator());
    }

    public Rational divide(Rational b)
    {
        return new Rational(this.getNumerator() * b.getDenominator(), this.getDenominator() * b.getNumerator());
    }



    public static void main(String[] args) {
        Rational x = new Rational();
        Rational y = new Rational(-24, -30);
        Rational z = new Rational(60, -1234);

        System.out.println("The default constructor should give us 0/1");
        System.out.println("The rational is " + x + " or " + x.getValue());
        System.out.println();

        System.out.println("Using constructor with -24, -30 should give us 4/5");
        System.out.println("The rational is " + y + " or " + y.getValue());
        System.out.println();

        System.out.println("Using constructor with 60, -1234 should give us -30/617");
        System.out.println("The rational is " + z + " or " + z.getValue());
        System.out.println();

        Rational r1 = new Rational(4, 16);
        Rational r2 = new Rational(10, 15);

        System.out.println(r1.toString() + " + " + r2.toString() + " = " + r1.add(r2));
        System.out.println(r1.toString() + " * " + r2.toString() + " = " + r1.multiply(r2));
    }
}
