package Lab21;

import java.util.Comparator;

public class CompareLines implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o1.compareTo(o2), 0);
    }
}
