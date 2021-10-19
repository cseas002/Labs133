package Lab18;

import java.util.Arrays;

public class ArraySort {

    public static int[] sort(int[] arr, int startIndex, int endIndex)
    {
        if (startIndex == endIndex) {
            System.out.println("Start index is the same as end index");
            return arr;
        }
        int[] arr2 = null;
        try {
            arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);
            Arrays.sort(arr2, startIndex, endIndex);
        } catch (NullPointerException e)
        {
            System.out.println("The array is null. The array will not change");
        } catch (IllegalArgumentException e)
        {
            System.out.println("Illegal argument");
            if (startIndex > endIndex)
                System.out.println("Start index is greater than end index");
        } catch (ArrayIndexOutOfBoundsException e)
        {
            if (startIndex < 0 || startIndex >= arr.length - 1)
                  System.out.println("Starting index is false");
            if (endIndex < 1 || endIndex > arr.length)
                  System.out.println("Ending index is false");

            System.out.println("The array will be returned as it is");
        } catch (Exception e)
        {
            System.out.println("Something is wrong");
        }

        return arr2;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < 20; i++)
            arr[i] = (int) (Math.random() * 100);
        System.out.println(Arrays.toString(arr));

        System.out.println("Sorting from index " + 0 + " to " + 20);

        System.out.println(Arrays.toString(sort(arr, 0, 20)));

        System.out.println("Sorting from index " + 10 + " to " + 20);

        System.out.println(Arrays.toString(sort(arr, 10, 20)));

        System.out.println("Sorting from index " + 10 + " to " + 10);

        System.out.println(Arrays.toString(sort(arr, 10, 10)));

        System.out.println("Sorting from index " + 20 + " to " + 10);

        System.out.println(Arrays.toString(sort(arr, 20, 10)));

        System.out.println("Sorting from index " + -1 + " to " + 10);

        System.out.println(Arrays.toString(sort(arr, -1, 10)));

        System.out.println("Sorting from index " + -1 + " to " + 21);

        System.out.println(Arrays.toString(sort(arr, -1, 21)));

        int[] arr2 = null;

        System.out.println(Arrays.toString(sort(arr2, -1, 21)));
    }
}
