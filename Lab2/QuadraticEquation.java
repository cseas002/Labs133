package Lab2;

public class QuadraticEquation {
    /**
     * @author Christoforos Seas
     */


    /**
     *
     * @param a the number before x^2
     * @param b the number before x
     * @param c the other number
     * @return diakrinousa
     */
    public static double diakrinousa (double a, double b, double c)
    {
        return b * b - 4 * a * c;
    }

    /**
     *
     * @param a before x^2
     * @param b before x
     * @param c the other number
     * @return roots in a double array
     */
    private static double[] generate_roots(double a, double b, double c)
    {
        double[] roots = new double[2];
        roots[0] = (-b + Math.sqrt(diakrinousa(a, b, c))) / 2 * a;
        roots[1] = (-b - Math.sqrt(diakrinousa(a, b, c))) / 2 * a;
        return roots;
    }


    public static void main(String[] args) {
        double roots[] = generate_roots(1, -5, 6); //x^2 -5x + 6 = (x - 3)*(x - 2)
        System.out.println(roots[0] + " " + roots[1]); // root1 = 3, root2 = 2
    }
}
