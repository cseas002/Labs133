package Lab17;

class A {
    int i = 1;

    class B
    {
        int i = 2;

        class C extends A
        {
            void methodC()
            {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        new A().new B().new C().methodC();
    }
}
