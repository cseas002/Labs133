package frontistiria;

public class Mozzarella extends Ingredient implements Pizza{
    private final double COST = 0.5;
    private double totalCost;
    private String description = "mozzarella";
    private String costDesc = "";

    public Mozzarella(Ingredient ingredient) {
        super(ingredient);
    }

    public Mozzarella() {}


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return "Moz";
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
