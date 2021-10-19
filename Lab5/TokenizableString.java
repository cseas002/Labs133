package Lab5;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class TokenizableString {
    private String token;
    private String[] lekseis;
    TokenizableString(String token)
    {
        this.token = token;
        lekseis = token.split("\\W+");
    }

    public String getToken()
    {
        return token;
    }

    public String get_leksi(int target)
    {
        return lekseis[target - 1];
    }

    public static void main(String[] args) {
        StdOut.print("Grapse protasi: ");
        String protasi = StdIn.readLine();
        TokenizableString test = new TokenizableString(protasi);
        StdOut.print("Poia Leksi theleis? (dwse arithmo): ");
        int leksi = StdIn.readInt();
        StdOut.println(test.get_leksi(leksi));
    }
}
