package frontistiria;

public class TomatoSauce extends Ingredient implements Pizza {
    private final double COST = 0.35;
    private double totalCost;
    private String description = "tomato sauce";
    private String costDesc = "";

    public TomatoSauce(Ingredient ingredient) {
        super(ingredient);
    }

    public TomatoSauce() {}


    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return "Sauce";
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
