package frontistiria;

import java.util.StringTokenizer;

public class EnhancedStringTokenizer extends StringTokenizer {
    /**
     * @author Christoforos Seas, Kypros Iakovou, Loukia Christina Ioannou
     */
    String str; //The first String
    int count = 0; //counter for tokens
    public EnhancedStringTokenizer(String str)
    {
        super(str);
        this.str = str;
    }

    public EnhancedStringTokenizer(String str, String delim)
    {
        super(str, delim);
        this.str = str;
    }

    public EnhancedStringTokenizer(String str, String delim, boolean returnDelims)
    {
        super(str, delim, returnDelims);
        this.str = str;
    }

    @Override
    public String nextToken() {
        count ++;
        return super.nextToken();
    }

    @Override
    public String nextToken(String delim)
    {
        count ++;
        return super.nextToken(delim);
    }

    public int TokensSoFar()
    {
        return count;
    }
}
