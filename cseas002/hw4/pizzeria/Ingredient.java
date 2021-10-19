package cseas002.hw4.pizzeria;
/**
 * @author Christoforos Seas 1028675
 * Enumeration of Ingredients
 * Price based on their position in the enum
 *
 */
public enum Ingredient {

    CHEESE, ONIONS, PINEAPPLE, PEPPERONI, CHICKEN, BEEF, SAUSAGE;

    private int price;

    Ingredient() {
        price = 1 + ordinal();
    }

    public int getPrice() {
        return price;
    }
}
