package cseas002.hw4.pizzeria;

import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Christoforos Seas 1028675
 * PizzaShack pizzera
 */

public class PizzaShack extends Pizzerias implements Pizzeria {

    private final String name = "PizzaShack";
    private final Set <Order> menu;

    private final PriorityQueue<Customer> customersList = new PriorityQueue<>(new Compare_Elements_PizzaShack());
    private int profit, processed_orders, orders, delivered_orders;

    /**
     * Constructor
     * @param menu the menu
     */
    public PizzaShack(Set <Order> menu) {
        this.menu = menu;
    }

    /**
     * Method which places the order
     * @param customer Customer who wants a pizza
     */
    @Override
    public void placeOrder(Customer customer) {
        orders ++;
        customersList.add(customer);
    }

    /**
     * name getter
     * @return name of the pizzeria (Cascade frontistiria.Pizza)
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * The process of the order
     */
    @Override
    public void processOrder() {
        Customer my_customer = customersList.remove();
        processed_orders ++;

        if (!check_valid(my_customer))
            return ;

        delivered_orders ++;
        profit += my_customer.getOrder().getPrice();
    }

    /**
     * profit getter
     * @return profit
     */
    @Override
    public int getProfit() {
        return profit;
    }

    /**
     * orders getter
     * @return orders
     */
    @Override
    public int getOrders() {
        return orders;
    }

    /**
     * delivered orders getter
     * @return delivered orders
     */
    @Override
    public int getDelivered_orders() {
        return delivered_orders;
    }

    /**
     * processed orders getter
     * @return processed orders
     */
    @Override
    public int getProcessed_orders() {
        return processed_orders;
    }

    /**
     * menu getter
     * @return menu
     */
    @Override
    public Set<Order> getMenu() {
        return menu;
    }
}
