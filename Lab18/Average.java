package Lab18;

import java.util.Scanner;

public class Average {

    private static float computeAverage()
    {
        int N = 0;
        Scanner scan = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            valid = true;
            try {
                N = scan.nextInt();
                if (N < 0)
                    throw new Exception("N must be positive");

            } catch (Exception e) {
                System.out.println(e.getMessage());
                valid = false;
            }
        }
        float sum = 0;
        for (int i = 0; i < N; i++) {
            valid = false;
            while (!valid) {
                valid = true;
                try {
                    sum += scan.nextInt();
                } catch (Exception e) {
                    System.out.println("Number must be integer");
                    valid = false;
                }
            }
        }
        return sum / N;
    }

    public static void main(String[] args) {
        System.out.println(computeAverage());
    }
}
