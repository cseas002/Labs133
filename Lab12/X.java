package Lab12;

class X {
    void method(int a) {
        System.out.println("ONE");
    }

    void method(double d) {
        System.out.println("TWO");
    }
}
class Y extends X {
    @Override
    void method(double d) {
        System.out.println("THREE");
    }
}

