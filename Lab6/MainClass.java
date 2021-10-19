package Lab6;

public class MainClass {

    public static void main(String[] args) {
        int[][] table = new int[3][];
        int i;
        System.out.println("The maximum: " + Runtime.getRuntime().maxMemory());
        System.out.println("the total: " + Runtime.getRuntime().totalMemory());
        System.out.println("free: " + Runtime.getRuntime().freeMemory());
        for (i = 0; i < 3; i++) {
            table[i] = new int[40000];
            System.out.println("i=" + i + " free :" + Runtime.getRuntime().freeMemory());
        }
        System.gc();
        System.out.println("\nAfter deallocation, free: " + Runtime.getRuntime().freeMemory() + "\n");
        for (i = 0; i < 3; i++) {
            table[i] = null;
            System.gc();
            System.out.println("i=" + i + " free :" + Runtime.getRuntime().freeMemory());
        }
    }
}