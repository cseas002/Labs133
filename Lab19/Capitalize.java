package Lab19;

import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Capitalize {

    public static void main(String[] args)
    {
        try
        {
            File fl = new File("words.txt");
            FileWriter fl2 = new FileWriter("test write.txt");
            Scanner scan = new Scanner(fl);
            while (scan.hasNext()) {
                String str = scan.next();
                fl2.write(str.substring(0, 1).toUpperCase() + str.substring(1) + "\n");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}



