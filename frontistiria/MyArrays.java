package frontistiria;

public class MyArrays {
    /**
     * @author Christoforos Seas 1028675
     */
    public int[] arr;

    public MyArrays() {}

    public MyArrays(int length)
    {
        this.arr = new int[length];
    }

    public MyArrays(int[] arr2)
    {
        arr = new int[arr2.length];

        for (int i = 0; i < arr2.length; i++)
         arr[i] = arr2[i];
    }

    public MyArrays(MyArrays other)
    {
        this(other.arr);
    }

    public int linearSearch(int a, int b, int c)
    {
        for (int i = b; i <= c; i++)
            if (arr[i] == a)
                return i;

            return -1;
    }

    public boolean equals(MyArrays other)
    {
        if (other.arr.length != this.arr.length)
            return false;

        for (int i = 0; i < arr.length; i++)
            if (arr[i] != other.arr[i])
                return false;

            return true;
    }

    public MyArrays fill(int a)
    {
        MyArrays other = new MyArrays(arr);
        for (int i = 0; i < other.arr.length; i++)
            arr[i] = a;

        return other;
    }

    public MyArrays copyOf(int a, int b)
    {
        if (a == b)
            return new MyArrays();
        int[] arr2 = new int[b - a];

        for (int i = a; i < b; i++)
            arr2[i - a] = i;

        return new MyArrays(arr2);
    }

    public MyArrays sort(int a, int b)
    {
        MyArrays arr2 = new MyArrays(this.copyOf(a, b));
        boolean sorted = false;

        do {
            sorted = true;

                for (int i = 0; i < arr2.arr.length - 1; i++)
                    if (arr2.arr[i] > arr2.arr[i + 1])
                    {
                        int temp = arr2.arr[i];
                        arr2.arr[i] = arr2.arr[i + 1];
                        arr2.arr[i + 1] = temp;
                        sorted = false;
                    }

        } while (!sorted);

        return arr2;
    }

    public MyArrays sort()
    {
        return sort(0, arr.length);
    }

    public String toString()
    {
        String str = "[";
        for (int i = 0; i < arr.length; i++)
            if (i != arr.length - 1)
            str += arr[i] + ", ";
            else
                str += arr[i] + "]";

        return str;
    }

    public MyArrays parallelPrefixPlus()
    {
        MyArrays arr2 = new MyArrays(arr);
        for (int i = 1; i < arr.length; i++)
            arr2.arr[i] += arr[i - 1];

        return arr2;
    }
}
