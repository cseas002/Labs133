package frontistiria;


import static java.lang.System.*;

public class Test {
    public static void main(String[] args)
    {
        String obj1 = "geeks";
        String obj2 = "geeks";
        if(obj1.hashCode() == obj2.hashCode())
            System.out.println("hashCode of object1 is equal to object2");

        if(obj1 == obj2)
            System.out.println("memory address of object1 is same as object2");

        if(obj1.equals(obj2))
            System.out.println("value of object1 is equal to object2");

        int x = Integer.MAX_VALUE;
        x>>= x;

        out.println(x);
    }

}
