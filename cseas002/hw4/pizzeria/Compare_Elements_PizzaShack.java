package cseas002.hw4.pizzeria;

import java.util.Comparator;

/**
 * @author Christoforos Seas 1028675
 * Class which is used by {@link PizzaShack} to sort the orders from high to low and
 * it depends from the ability of the customer to pay
 */

public class Compare_Elements_PizzaShack implements Comparator<Customer> {
    /**
     * Sorts the Queue by the customers' orders from High to Low and their ability to pay
     *
     * @param customer1 the first customer
     * @param customer2 the second customer
     * @return a positive number if the second customer's order price is higher than the first customer's
     * AND can pay for his/her order
     * else 0 if the customer's order is the same as the first
     * else a negative number if the first customer's order price is higher than the second customer's
     */
    @Override
    public int compare(Customer customer1, Customer customer2) {
        //if he can pay and his order's price is higher than the first then swap
        if (customer2.getOrder().getPrice() > customer1.getOrder().getPrice() && customer2.getMoney() >= customer2.getOrder().getPrice())
             return 1;

        //if he can pay and the second can't, then swap
        if (customer2.getMoney() >= customer2.getOrder().getPrice() && customer1.getMoney() < customer1.getOrder().getPrice())
            return 1;

        //if he can't pay and the first can then don't swap
        if (customer1.getMoney() >= customer1.getOrder().getPrice() && customer2.getMoney() < customer2.getOrder().getPrice())
            return -1;

        //if neither of them can pay then return 0
        if (customer1.getMoney() < customer1.getOrder().getPrice() && customer2.getMoney() < customer2.getOrder().getPrice())
            return 0;

        //else don't swap
        return -1;
    }
}

