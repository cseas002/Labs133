package tutorials;

public class Dog extends Animal{
    public Dog()
    {
        System.out.println("Woof");
        this.setName("Pampos");
        System.out.println(getName());
    }

    public Dog(boolean test)
    {
        super(true);
    }

    public static void main(String[] args) {
        Animal Pyrros = new Animal();
        Dog Sazeidis = new Dog();
    }
}
