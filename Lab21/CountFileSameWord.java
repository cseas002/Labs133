package Lab21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountFileSameWord {
    public static void main(String[] args) {
        ArrayList <String> words = new ArrayList<>();
        int wordsCounter = 0;
        Scanner scan = null;
        try {
            scan = new Scanner(new File("same words.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNext())
        {
            words.add(scan.next());
            wordsCounter ++;
        }

        int[] linesTimes = new int[wordsCounter];

        for (int i = 0; i < wordsCounter; i++)
            linesTimes[i] = countTimes(words, i);

        for (int i = 0; i < wordsCounter; i++)
            System.out.println(words.get(i) + " occurs " + linesTimes[i] + " times");
    }

    private static int countTimes(ArrayList<String> words, int i) {
        int times = 0;
        for (String word : words)
            if (word.equals(words.get(i)))
                times++;

        return times;
    }
}
