package Lab2;

import edu.princeton.cs.introcs.StdOut;

public class LinearEquation {
    /**
     * @author Christoforos Seas
     */


    private double a, b, c, d, e, f;
    private double[] roots = new double[2];
    /**
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     * @return solutions in an array
     */

    public LinearEquation(double a, double b, double c, double d, double e, double f)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        roots = calculate_solutions(a, b, c, d, e, f);
    }
    private static double[] calculate_solutions(double a, double b, double c, double d, double e, double f)
    {
        double[] solutions = new double[2];
        solutions[0] = generate_x(a, b, c, d, e, f);
        solutions[1] = generate_y(a, b, c, d, e, f);
        return solutions;
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     * @return x root
     */
    private static double generate_x(double a, double b, double c, double d, double e, double f)
    {
        return (e * d - b * f) / (a * d - b * c);
    }

    /**
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @param f
     * @return y root
     */
    private static double generate_y(double a, double b, double c, double d, double e, double f)
    {
        return (a * f - e * c) / (a * d - b * c);
    }

    public static void main(String[] args) {
        double[] roots_test = calculate_solutions(4, 1, 4, 0, 5, 1); //4x + y = 5  4x = 1 => x = 0.25, y = 4
        StdOut.println(roots_test[0] + " " + roots_test[1]);
    }
}
