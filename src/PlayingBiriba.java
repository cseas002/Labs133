public class PlayingBiriba {

    private static final String[] Suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
    private static final String[] Rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King",
            "Ace" };

    public static String[] generateDoubleDeck() {
        String[] deck = new String[52];
        int count = 0;
        for (int r = 0; r < Rank.length; r++)
            for (int s = 0; s < Suit.length; s++) {
                deck[count] = Rank[r] + " of " + Suit[s];
                count++;
            }
        String[] doubleDeck = new String[2 * (deck.length + 1)];
        doubleDeck[0] = "Joker";
        doubleDeck[1] = "Joker";
        count = 2;
        for (int i = 1; i <= 2; i++)
            for (int j = 0; j < deck.length; j++) {
                doubleDeck[count] = deck[j];
                count++;
            }
        return doubleDeck;
    }

    public static void shuffleDeck(String[] deck) {
        for (int i = 1; i <= 1000; i++) {
            int j = (int) (Math.random() * deck.length);
            int k = (int) (Math.random() * deck.length);
            String s = deck[j];
            deck[j] = deck[k];
            deck[k] = s;
        }
    }

    public static String getSuit(String card) {
        if (card.contains("Clubs"))
            return "Clubs";
        else if (card.contains("Diamonds"))
            return "Diamonds";
        else if (card.contains("Hearts"))
            return "Hearts";
        else if (card.contains("Spades"))
            return "Spades";
        else if (card.equals("Joker"))
            return "Joker";
        return "";
    }

    public static String getRank(String card) {
        if (card.equals("Joker"))
            return "Joker";
        int i = card.indexOf(" of ");
        return card.substring(0, i);
    }

    public static void display(String[] cards) {
        for (String c : cards)
            System.out.println(c);
    }

}