package tutorials;

public class AssemblyProgram {
    static void shiftRight(int[] arr, int i) {
        arr[i + 1] = arr[i];
    }
    static void InsertionSort(int[] arr, int n) {
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                shiftRight(arr, j);
                j--;
            }
            arr[j + 1] = key;
        }
    }
    static void printArray(int[] arr, int n) {
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 12, 11, 3, 21, 13, 5, 0, 6, 88, 99, 11, 22 };
        printArray(arr, arr.length);
        InsertionSort(arr, arr.length);
        printArray(arr, arr.length);
    }
}