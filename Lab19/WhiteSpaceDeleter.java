package Lab19;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WhiteSpaceDeleter {
    private static final ArrayList<String> myList = FileToList.createList(new File("words.txt"));

    public static void main(String[] args)
    {
        try
        {
            FileWriter fl2 = new FileWriter("test write.txt"); //should be replaced with "words.txt"
            while (!myList.isEmpty())
                fl2.write(myList.remove(0));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
