public class MyInteger {
    private int value;

    MyInteger(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }

    public boolean isEven()
    {
        return value % 2 == 0;
    }

    public boolean isOdd()
    {
        return value % 2 != 0;
    }

    public boolean isPrime()
    {
        if (value == 2)
            return true;

        for (int i = 2; i < value / 2; i++)
            if (value % i == 0)
                return false;


            return true;
    }

    public static boolean isEven(int integer)
    {
        return integer % 2 == 0;
    }

    public static boolean isOdd(int integer)
    {
        return integer % 2 != 0;
    }

    public static boolean isPrime(int integer)
    {
        if (integer == 2)
            return true;

        for (int i = 2; i < integer / 2; i++)
            if (integer % i == 0)
                return false;


        return true;
    }

    public static boolean isEven(MyInteger integer)
    {
        return integer.getValue() % 2 == 0;
    }

    public static boolean isOdd(MyInteger integer)
    {
        return integer.getValue() % 2 != 0;
    }

    public static boolean isPrime(MyInteger integer)
    {
        if (integer.getValue() == 2)
            return true;

        for (int i = 2; i < integer.getValue() / 2; i++)
            if (integer.getValue() % i == 0)
                return false;


        return true;
    }

    public boolean equals(int other)
    {
        return other == value;
    }

    public boolean equals(MyInteger other)
    {
        return other.getValue() == value;
    }

    public static int parseInt(char[] num)
    {
        int ans = 0;
        double count = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int plus_value = (int) (Math.pow(10, count)) *  Character.getNumericValue(num[i]);
            ans += plus_value;
            count++;
        }

        return ans;
    }

    public static int parseInt(String num)
    {
        int ans = 0;
        int count = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int plus_value = (int) (Math.pow(10, count)) *  Character.getNumericValue(num.charAt(i));
            ans += plus_value;
            count++;
        }

        return ans;
    }

}
