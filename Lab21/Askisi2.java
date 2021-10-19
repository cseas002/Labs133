package Lab21;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Askisi2 {
    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("names.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scan.hasNextLine())
        {
            String key = scan.next();
            String value = scan.next();

            if (!(names.containsKey(key)))
                names.put(key, value);
            else if (!names.get(key).equals(value))
                names.put(key, value);

        }

        Set<String> keys = names.keySet();

        for (String str : keys)
            System.out.println("Name: " + str + " " + names.get(str));
    }
}
