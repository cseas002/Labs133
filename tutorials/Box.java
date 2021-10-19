package tutorials;


import java.util.LinkedList;

public class Box<T> {
    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void inspect(Object u) {
        System.out.println("T: " + t.getClass().getName());
        System.out.println("U: " + u.getClass().getName());
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        Box<Integer> integerBox1 = new Box<>();
        integerBox = integerBox1;

        LinkedList<String> list = new LinkedList<>();
    }
}