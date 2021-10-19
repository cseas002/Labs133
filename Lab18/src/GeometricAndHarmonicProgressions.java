public class GeometricAndHarmonicProgressions {

    private static int factorial(int n)
    {
        if (n == 1 || n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    private static double reversefactorial(int n)
    {
        if (n == 1)
            return 1;
        double x = (double) 1 / n;
        return x * reversefactorial((n - 1));
    }

    public static void main(String[] args)
    {
        int a = StdIn.readInt();
        StdOut.println(factorial(a));
        StdOut.println(reversefactorial(a));
    }
}
