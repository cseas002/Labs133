package tutorials;

import java.util.PriorityQueue;

public class PsifosSeXarti extends VoteTutorial{

    public PsifosSeXarti()
    {
        super();
    }

    @Override
    protected String getName() {
        return "xarti";
    }

    @Override
    public String toString() {
        return "psifos se xarti";
    }

    public static void main(String[] args) {
        PsifosSeXarti psifos = new PsifosSeXarti();

        PriorityQueue <FoititisPrwtoetis> oura = new PriorityQueue<>(6, new SygkrisiFoititwn());
        oura.add(new FoititisPrwtoetis(99));
        oura.add(new FoititisPrwtoetis(54));
        oura.add(new FoititisPrwtoetis(923));
        oura.add(new FoititisPrwtoetis(1));
        oura.add(new FoititisPrwtoetis(29));
        oura.add(new FoititisPrwtoetis(94));


        for (int i = 0; i < 6; i++)
        System.out.println(oura.remove().getID());
    }
}
