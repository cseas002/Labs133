package Lab15;


class A
{
    protected static int x()
    {
        return 3;
    }
    public void printX()
    {
        System.out.println(x());
    }
}

class B extends A
{
    public static int x()
    {
        return 4;
    }
}
public class Test {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.x());
        a.printX();

        B b = new B();
        System.out.println(b.x());
        b.printX();

        A ab = new B();
        System.out.println(ab.x());
        ab.printX();
    }
}
