package Lab17;

class X {
    static int x = 3131;

    static class Y
    {
        static int y = x++;

        static class Z
        {
            static int z = y++;
        }
    }
    {
        System.out.println(1);
    }

    static
    {
        System.out.println(2);
    }

    public X()
    {
        new Y();
    }

   // static class Y
   // {
   //     {
    //        System.out.println(3);
    //    }

     //   static
    //    {
     //       System.out.println(4);
     //   }
  //  }

    public static void main(String[] args) {
       // X x = new X();
       // X.Y y = new X.Y();
        System.out.println(X.x);
        System.out.println(X.Y.y);
        System.out.println(X.Y.Z.z);
    }
}
