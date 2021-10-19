package Lab19;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFile {
    public static void main(String[] args)
    {
        try
        {
            File fl = new File("words.txt");
            FileWriter fl2 = new FileWriter("test write.txt");
            Scanner scan = new Scanner(fl);
            while (scan.hasNext())
                fl2.write(scan.next() + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
