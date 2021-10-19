package Lab17;

class ABC {
   class XYZ
    {
        void test()
        {
            class B
            {
                void test2()
                {

                }
            }
        }
        int i = 111;
    }

    public static void main(String[] args) {
        System.out.println(new ABC().new XYZ().i);
        new ABC().new XYZ().test();
    }
}

class C extends ABC.XYZ
{
    public C()
    {
        new ABC().super();
    }
}
