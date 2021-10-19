package tutorials;

import edu.princeton.cs.introcs.StdIn;

public class Assembly {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        int z = 0;
            for (int x = 1; x <= N; x++) {
                int a = 0;
                for (int y = 1; y <= x; y++)
                    a += y + y;
                z += x + a;
            }
            System.out.println("For N " + N + " The value of z = " + z);
    }
}
