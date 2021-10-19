public class Reverse {

    private static void rev(int i)
    {
        if (i == 0)
            return ;
        StdOut.println("Dwse arithmo:");
        int a = StdIn.readInt();
        rev(a);
        if (a == 0)
            StdOut.println();
        else
        StdOut.println(a);
    }

    public static void main(String[] args)
    {
        StdOut.println("Tha doseis mia seira akeraion arithmon ena-ena.\nDwse 0 gia termatismo.");
        rev(4);
    }
}
