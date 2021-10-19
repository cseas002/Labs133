package frontistiria;

public class MyArrayTest1 {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 7, 8, 4, 5, 6, 9, 8, 7 };
        MyArrays myArr = new MyArrays(arr);

        System.out.println("-------------------------------------------------");

        System.out.println("Initial array -> " + myArr);

        System.out.println("-------------------------------------------------");

        System.out.println("Testing equals-> " + myArr.equals(myArr));

        System.out.println("-------------------------------------------------");

        System.out.println("Linear Search -> " + myArr.linearSearch(8, 3, 8));

        System.out.println("-------------------------------------------------");

        MyArrays filledArr1 = myArr.fill(1);
        System.out.println("Initial array -> " + myArr);
        System.out.println("Filled  array -> " + filledArr1);

        System.out.println("-------------------------------------------------");

        MyArrays copyArr = myArr.copyOf(3, 8);
        System.out.println("Initial array -> " + myArr);
        System.out.println("Copied  array -> " + copyArr);

        System.out.println("-------------------------------------------------");

        MyArrays sortArr = myArr.sort(3, 8);
        System.out.println("Initial array -> " + myArr);
        System.out.println("Sorted* array -> " + sortArr + "\n");

        MyArrays sortArr1 = myArr.sort();
        System.out.println("Initial array -> " + myArr);
        System.out.println("Sorted  array -> " + sortArr1);

        System.out.println("-------------------------------------------------");

        MyArrays parPrefixArr = myArr.parallelPrefixPlus();
        System.out.println("Initial array -> " + myArr);
        System.out.println("Parallel pref -> " + parPrefixArr);

    }
}