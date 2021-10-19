package cseas002.hw4.pizzeria;

import java.util.Comparator;

/**
 * @author Christoforos Seas 1028675
 * Class which is used by {@link MarySuePizza} to sort the orders from high to low
 */

public class Compare_Elements implements Comparator <Customer> {
    /**
     * Sorts the Queue by the customers' orders from High to Low
     *
     * @param customer1 the first customer
     * @param customer2 the second customer
     * @return a positive number if the second customer's order price is higher than the first customer's
     * else 0 if the customer's order is the same as the first
     * else a negative number if the first customer's order price is higher than the second customer's
     */
    @Override
    public int compare(Customer customer1, Customer customer2) {
        //integer comparison of the 2 prices
        return Integer.compare(customer2.getOrder().getPrice(), customer1.getOrder().getPrice());
    }
}
