package cseas002.hw4.pizzeria;

import java.util.Set;

/**
 * @author Christoforos Seas 1028675
 * The abstract class of pizzerias
 * Abstracts all pizzerias which are {@link MarySuePizza}, {@link PizzaShack}, {@link CascadePizza}
 * Used to abstract methods and code reuse
 */

abstract public class Pizzerias {

    /**
     * menu getter
     * @return the menu
     */
    abstract public Set<Order> getMenu();

    /**
     * delivered orders getter
     * @return delivered orders
     */
    abstract public int getDelivered_orders();

    /**
     * orders getter
     * @return orders
     */
    abstract public int getOrders();

    /**
     * processed orders getter
     * @return processed orders
     */
    abstract public int getProcessed_orders();

    /**
     * profit getter
     * @return profit
     */
    abstract public int getProfit();

    /**
     * Method implemented from {@link Pizzeria}
     * used to calculate and return the most expensive menu item
     * @return most expensive menu item
     */
    public Order getMostExpensiveMenuItem() {
        Order most_expensive = new Order();
        int most_expensive_item = 0;

        for (Order item : getMenu()) //dynamic binding so it gets the getMenu() method from subclass
            if (item.getPrice() > most_expensive_item) {
                most_expensive_item = item.getPrice();
                most_expensive = item;
            }

        return most_expensive;
    }

    /**
     * Method implemented from {@link Pizzeria}
     * Used to calculate and return the cheapest menu item
     * @return cheapest menu item
     */
    public Order getCheapestMenuItem() {
        Order cheapest = new Order();
        int cheapest_item = 99999;

        for (Order item : getMenu()) //dynamic binding so it gets the getMenu() method from subclass
            if (item.getPrice() < cheapest_item) {
                cheapest_item = item.getPrice();
                cheapest = item;
            }

        return cheapest;
    }

    /**
     * Method which checks if the customer's order is valid
     * A customer's order is valid if it's in the menu
     * and if he has enough money to pay for his order
     * @param customer the customer
     * @return true if his order is valid else false
     */
    public boolean check_valid(Customer customer)
    {
        for (Order item : getMenu())
        if (customer.getOrder().ingredients.equals(item.ingredients) && customer.getMoney() >= item.getPrice())
            return true;

        return false;
    }

    /**
     * Method implemented from {@link Pizzeria}
     * Used to print the status of each pizzeria
     * @return status
     */
    public String status()
    {
        int orders_percentage = 100 * getDelivered_orders() / getOrders(), attempted_orders_percentage = 100 * getDelivered_orders() / getProcessed_orders();
        return "We delivered " + orders_percentage + "% of our orders! We delivered " + attempted_orders_percentage + "% of our attempted orders and made $" + getProfit() + ".00";
    }

    public static void main(String args[]) {
        try {
            int a = 5/0;
            //throw new ArithmeticException();
        }
        catch (ArithmeticException t)
        {
            System.out.println("test");
            throw new ArrayIndexOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException t) {
            System.out.println("Got the Test Exception");
        }
        finally {
            System.out.println("Inside finally block ");
        }

        Pizzeria[] arr = new Pizzeria[5];
    }

}
