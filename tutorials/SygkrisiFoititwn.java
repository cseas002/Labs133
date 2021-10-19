package tutorials;

import java.util.Comparator;

public class SygkrisiFoititwn implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        FoititisPrwtoetis foititis1 = (FoititisPrwtoetis) o1;
        FoititisPrwtoetis foititis2 = (FoititisPrwtoetis) o2;

       return Integer.compare(foititis2.getID(), foititis1.getID());
    }
}
