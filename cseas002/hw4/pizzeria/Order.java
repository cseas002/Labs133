package cseas002.hw4.pizzeria;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Christoforos Seas 1028675
 * Order class
 */

public class Order {
    Queue <Ingredient> ingredients = new LinkedList<>();

    /**
     * Constructor
     */
    public Order() {}

    /**
     * Method which adds an ingredient
     * @param ingredient the ingredient to be added
     */
    public void add(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    /**
     * price getter
     * @return price
     */
    public int getPrice()
    {
        int price = 0;
        for (Ingredient item : ingredients)
            price += item.getPrice();

        return price;
    }

    public boolean isEmpty() {
        return ingredients.isEmpty();
    }
}
