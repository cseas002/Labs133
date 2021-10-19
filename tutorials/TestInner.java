package tutorials;

import java.util.HashMap;
import java.util.Iterator;

class A {
    static class B {
        int i = 0;
        B() {
            System.out.println("Hello from A.B");
        }
        void test()
        {
            System.out.println(this.i);
        }
    }
}

class AA extends A {
     static class B extends A.B{
         static
         {
             System.out.println("SIB");
         }
        static int i = 1;
        B() {
            System.out.println("Hello from AA.B");
        }
        void test()
        {
            System.out.println(i);
        }

        static void test2()
        {
            System.out.println("test");
        }

    }

    void test()
    {
        System.out.println(B.i);
    }
}

public class TestInner {
    public static void main(String[] args) {
       // A a = new A();
      //  A.B b = a.new B();
       // AA a1 = new AA();
       // AA.B c = new AA.B();

        AA testAA = new AA();
     //   testAA.test();

       // System.out.println(c.i);
        //c.test();

        /*HashMap <String, Integer> test = new HashMap<>();
        test.put("Pampos", 1);
        Iterator<String> stringIterator = test.keySet().iterator();

        while (stringIterator.hasNext())
            System.out.println(stringIterator.next());*/

    }
}