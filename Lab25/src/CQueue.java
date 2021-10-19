public class CQueue {

    private int[] elems;

    public CQueue() {}

    public void enqueuer(int a)
    {
        if (elems == null)
        {
            int[] elems2 = new int[1];
            elems2[0] = a;
            elems = elems2;
            return;
        }
        int[] elems2 = new int[elems.length + 1];

        for (int i = 0; i < elems.length; i++)
            elems2[i] = elems[i];

        elems2[elems.length] = a;
        elems = elems2;
    }

    public int dequeuer()
    {
        if (elems.length == 1)
        {
            int x = elems[0];
            elems = null;
            return x;
        }
        int[] elems2 = new int[elems.length - 1];
        for (int i = 1; i < elems.length; i++)
            elems2[i - 1] = elems[i];

        int x = elems[0];
        elems = elems2;
        return x;

    }

    public int getSize()
    {
        return elems == null ? 0 : elems.length;
    }

    public boolean isempty()
    {
        return getSize() == 0;
    }

    public static void main(String[] args)
    {
        CQueue Josephus = new CQueue();
        int N = StdIn.readInt();

        for (int i = 1; i <= N; i++)
            Josephus.enqueuer(i);

        int k = StdIn.readInt();

        while (!Josephus.isempty())
        {
            int num = 1;
            for (int i = 1; i <= Josephus.getSize(); i++)
                if (i % k == 0) {
                    StdOut.println("Dead No " + num + ": " + Josephus.dequeuer());
                    num ++;
                }
            else if (Josephus.getSize() > 1)
                Josephus.enqueuer(Josephus.dequeuer());
            else {
                    StdOut.println("Dead No " + num + ": " + Josephus.dequeuer());
                    break;
                }
        }
    }
}
