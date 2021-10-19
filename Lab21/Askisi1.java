package Lab21;

import edu.princeton.cs.introcs.StdIn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Askisi1 {

    public static void main(String[] args) {
        HashMap <Integer, Integer> map = new HashMap<>();
        int key;

        while (true)
        {
            key = StdIn.readInt();
            if (key == -1)
                break;

            if (!map.containsKey(key))
                map.put(key, 1);
            else
                map.replace(key, map.get(key) + 1);

        }

        Set <Integer> keys = map.keySet();


        for (Integer i : keys)
            System.out.println("The number " + i + " occurs " + map.get(i) + " times");
    }
}
