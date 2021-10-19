package Lab21;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SortLines {
    public static void main(String[] args) {
        PriorityQueue <String> lines = new PriorityQueue<>(new CompareLines()); // can avoid new CompareLines()
        Scanner scan = null;
        try {
            scan = new Scanner(new File("same lines.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine())
        {
            lines.add(scan.nextLine());
        }

        while (!lines.isEmpty())
            System.out.println(lines.remove());
    }
}
