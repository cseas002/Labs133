public class Vector {
    public double[] pos;

    public Vector(double[] pos) {
        this.pos = pos;
    }


    public Vector plus(Vector other) {
        double sum[] = new double[pos.length];
        for (int i = 0; i < pos.length; i++)
            sum[i] = this.pos[i] + other.pos[i];

        return new Vector(sum);
    }

    public Vector minus(Vector other) {
        double ans[] = new double[pos.length];
        for (int i = 0; i < pos.length; i++)
            ans[i] = this.pos[i] - other.pos[i];

        return new Vector(ans);
    }

    public Vector times(double t) {
        double ans[] = new double[pos.length];
        for (int i = 0; i < pos.length; i++)
            ans[i] = this.pos[i] * t;


        return new Vector(ans);
    }

    public double dot(Vector other)
    {
        double ans = 0;
        for (int i = 0; i < pos.length; i++)
            ans += this.pos[i] * other.pos[i];

        return ans;
    }

    public double magnitude()
    {
        double sum = 0;
        for (double i : pos)
            sum += i * i;
        return Math.sqrt(sum);
    }

    public Vector direction()
    {
        double[] pos2 = new double[pos.length];
        double magn = magnitude();
        for (int i = 0; i < pos.length; i++)
            pos2[i] = pos[i] / magn;

        return new Vector(pos2);
    }

    public double cartesian(int i)
    {
        return pos[i];
    }

    public String toString()
    {
        String str = "{";

        for (double po : pos)
            str += po + ", ";

        str += "}";
        return str;
    }


    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };
        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);
        StdOut.println("x = " + x);
        StdOut.println("y = " + y);
        StdOut.println("x + y = " + x.plus(y));
        StdOut.println("10x = " + x.times(10.0));
        StdOut.println("|x| = " + x.magnitude());
        StdOut.println("<x, y> = " + x.dot(y));
        StdOut.println("|x - y| = " + x.minus(y).magnitude());
    }
}
