package Lab19;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class FileToList
{
    public static ArrayList<String> createList(File fileName)
    {
        File fl = fileName;
        ArrayList<String> myList= new ArrayList<>();
        try
        {
            Scanner scan = new Scanner(fl);
            while (scan.hasNext())
                myList.add(scan.next());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return myList;
    }
    public static void main(String[] args)
    {
        ArrayList<String> myList = createList(new File("words.txt"));

        for (String str : myList)
         System.out.println(str);
    }
}
