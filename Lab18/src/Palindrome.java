public class Palindrome {

    private static String checkPalindrome(String str)
    {
        if (str.length() == 0)
            return str;
        return checkPalindrome(str.substring(1, str.length())) + str.substring(0, 1);
    }

    public static void main(String[] args)
    {
        String str = StdIn.readString();

        if (checkPalindrome(str).equals(str))
            StdOut.println("palindrome");
        else
            StdOut.println("not palindrome");
    }
}
