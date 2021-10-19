package frontistiria;

public abstract class Ingredient implements Pizza{
    public Ingredient(Ingredient other)
    {
        addToTotalCost(other.getTotalCost());
        setDescription(getDescription() + ", " + other.getDescription());
        System.out.println("Adding " + getName());
    }


    public Ingredient() {
        addToTotalCost(this.getTotalCost());
        setDescription(getDescription() + ", " + getDescription());
        System.out.println("Adding " + getName());
    }

    public abstract void setDescription(String s);
    public abstract String getName();
    public abstract void addToTotalCost(double othersCost);
}
