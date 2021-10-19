package tutorials;

interface  Contents {
    int value();
}

public class Parcel7 {
    private int i = 11;
    public Contents cont() {
        return () -> i; // Semicolon required in this case
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.cont();
        int c2 = p.cont().value();
        System.out.println(c2);
        System.out.println(c.value());
        new Parcel7().test();
    }

    private void test() {
        System.out.println(cont().value());
        System.out.println(cont().getClass());
    }
}