package tutorials;

public class Animal {
    private String color;
    private String name;

    public Animal()
    {
        System.out.println("Arrrr");
    }

    public Animal(boolean test)
    {
        System.out.println("Grrrr");
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getName() {
        return name;
    }
}
