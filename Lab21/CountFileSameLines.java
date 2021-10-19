package Lab21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountFileSameLines {
    public static void main(String[] args) {
        ArrayList <String> lines = new ArrayList<>();
        int linesCounter = 0;
        Scanner scan = null;
        try {
            scan = new Scanner(new File("same lines.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine())
        {
            lines.add(scan.nextLine());
            linesCounter ++;
        }

        int[] linesTimes = new int[linesCounter];

        for (int i = 0; i < linesCounter; i++)
            linesTimes[i] = countTimes(lines, i);

        for (int i = 0; i < linesCounter; i++)
            System.out.println(lines.get(i) + " occurs " + linesTimes[i] + " times");
    }

    private static int countTimes(ArrayList<String> lines, int i) {
        int times = 0;
        for (String line : lines)
            if (line.equals(lines.get(i)))
                times++;

            return times;
    }
}
