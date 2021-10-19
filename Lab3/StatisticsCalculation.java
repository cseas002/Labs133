package Lab3;

import edu.princeton.cs.introcs.StdIn;

public class StatisticsCalculation {
    private double number[];
    private int n;

    public StatisticsCalculation() {}

    public StatisticsCalculation(int n)
    {
        this.n = n;
        number = new double[n];
        for (int i = 0; i < n; i++)
        number[i] = StdIn.readDouble();
    }

    public void add(double num)
    {
        double[] num2 = new double[n + 1];

        for (int i = 0; i < n; i++)
            num2[i] = number[i];

        num2[n] = num;
        number = num2;
    }

    public void remove(double num)
    {
        double[] num2 = new double[n - 1];

        for (int i = 0; i < n; i++)
            if (number[i] == num)
            {
                for (int j = i; j < n - 1; j++)
                    number[j] = number[j + 1];

                break;
            }

        for (int i = 0; i < n - 1; i++)
            num2[i] = number[i];

        number = num2;
        n--;
    }

    public void removeAll(double num)
    {
        int count = n;
        boolean found = false;

        while (!found) {
            found = false;
            for (int i = 0; i < n; i++)
                if (number[i] == num) {
                    count--;
                    found = true;

                    for (int j = i; j < n - 1; j++)
                        number[j] = number[j + 1];
                    break;
                }
        }

        double[] num2 = new double[count];

        for (int i = 0; i < count; i++)
            num2[i] = number[i];

        number = num2;
        n = count;
    }

    public void removeAll()
    {
        n = 0;
        number = new double[0];
    }

    public double sum()
    {
        double sums = 0;

        for (double i : number)
            sums += i;

        return sums;
    }

    public double getAverage()
    {
        return sum() / n;
    }

    public double max()
    {
        double maxi = number[0];

        for (double i : number)
            if (i > maxi)
                maxi = i;

            return maxi;
    }

    public double min()
    {
        double mini = number[0];

        for (double i : number)
            if (i < mini)
                mini = i;

        return mini;
    }

    public int maxOccurances()
    {
        double maxi = max();
        int counti = 0;

        for (double i : number)
            if (i == maxi)
                counti ++;

            return counti;
    }
}
