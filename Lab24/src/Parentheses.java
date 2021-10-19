public class Parentheses {

    public static void main(String[] args)
    {
        String str = StdIn.readString();
        CStack a = new CStack(str.length());

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '{')
               a.push('{');
            else if (str.charAt(i) == '[')
                a.push('[');
            else if (str.charAt(i) == '(')
                a.push('(');
            else if (str.charAt(i) == '}')
                if(a.pop() == '{');
                else
                    break;

            else if (str.charAt(i) == ']')
                if(a.pop() == '[');
                else
                    break;

            else if (str.charAt(i) == ')')
                if(a.pop() == '(');
                else
                    break;
        }
        StdOut.println(a.length() == 0);
    }
}
