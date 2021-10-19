package Lab7;

import java.util.StringTokenizer;

/**
 * {@link #findMax(int[])}
 */

public class Calculation {

    public static int findMax(int arr[]){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(max<arr[i])
                max=arr[i];
        }
        return max;
    }

    public static int cube(int n) {
        return n * n * n;
    }
    // method that returns reverse words
    public static String reverseWord(String str) {
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(str, " ");
        while (tokenizer.hasMoreTokens()) {
            StringBuilder sb = new StringBuilder();
            if (tokenizer.hasMoreTokens())
            sb.append(tokenizer.nextToken());
            sb.reverse();
            result.append(sb);
            result.append(" ");

        }
        return result.toString();
    }
}