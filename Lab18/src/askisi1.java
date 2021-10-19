public class askisi1 {

    private static double sum(int n) // n>=1
    {
        if (n == 1)
            return 1;
        double x = (double) 1 / n;

        return x + sum(n - 1);
    }

    public static void main(String[] args)
    {
        int n = StdIn.readInt();
        double x = sum(n);
        StdOut.println(x);

    }
}
