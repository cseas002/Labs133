public class NumberOfDigits {

    private static int digits(int a) //a > 0
    {
        if (a < 10)
            return 1;
        return 1 + digits(a / 10);
    }

    public static void main(String[] args)
    {
        int a = StdIn.readInt();
        StdOut.println(digits(a));
    }
}
