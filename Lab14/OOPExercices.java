package Lab14;

public class OOPExercices {


    public static void main(String[] args) {
        A objA = new A();
        B objB1 = new B();
        A objB2 = new B();
        objA.display();
        objB1.display();
        objB2.display();

    }
}

class A
{
    int a = 100;

    public void display()
    {
        System.out.println("a in A " + a);
    }
}

class B extends A
{
    int a = 123;

    public void display()
    {
        System.out.println("a in B " + a);
    }
}
