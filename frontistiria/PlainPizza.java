package frontistiria;

public class PlainPizza extends Ingredient implements Pizza{
    private final double COST = 4;
    private double totalCost;
    private String description = "Thin Dough";
    private String costDesc = "";

    public PlainPizza(Ingredient ingredient) {
        super(ingredient);
    }

    public PlainPizza() {}


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return "Dough";
    }

    @Override
    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return COST;
    }

    @Override
    public void addToTotalCost(double othersCost) {
        costDesc += othersCost;
        totalCost = COST + othersCost;
    }
}
