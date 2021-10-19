package Lab4;

import edu.princeton.cs.introcs.StdOut;

public class Mouse {
    public static final int LIFESPAN = 36;
    private int weight;
    private int age = 0;
    private int life_expectance;
    private boolean clone;
    private String color;

    public Mouse(int weight, String color, int age, int lifespan)
    {
        this.weight = weight;
        this.color = color;
        this.age = age;
        this.life_expectance = lifespan;
        this.clone = false;
        StdOut.println("A new mouse !");
    }

    public Mouse(int weight, String color, int age)
    {
        this(weight, color, age, LIFESPAN);
    }

    public Mouse(int weight, String color)
    {
        this(weight, color, 0);
    }

    public Mouse(Mouse other)
    {
        this.weight = other.weight;
        this.age = other.age;
        this.color = other.color;
        clone = true;
        life_expectance = 4 * other.life_expectance / 5;
        StdOut.println("Cloning a mouse !");
    }

    public String toString()
    {
        if (!clone)
        return "A " + this.color + " mouse of " + this.age + " months and of weight " + weight + " grammes";
        else
            return "A " + this.color + " mouse, cloned, of " + this.age + " months and of weight " + weight + " grammes";
    }

    public void evolution()
    {
        //afksanetai kata 1 i ilikia if (clone && age > lifespan / 2) change color to verte
        while (age < life_expectance)
        {
            age ++;
            if (clone && age > life_expectance / 2)
                color = "green";
        }
    }
}
