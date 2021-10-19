package cseas002.hw4.pizzeria;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Christoforos Seas 1028675
 * Cascade frontistiria.Pizza class
 */

public class CascadePizza extends Pizzerias implements Pizzeria{

    /**
     * menu getter
     * @return menu
     */
    public Set<Order> getMenu() {
        return menu;
    }

    private final Set <Order> menu;
    private final String name = "Cascade frontistiria.Pizza";
    private final Queue <Customer> customersList = new LinkedList<>();

    private int profit, orders, delivered_orders, processed_orders;

    /**
     * Constructor
     * @param menu the menu
     */
    public CascadePizza(Set <Order> menu) {
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
    public int getProfit() {
        return profit;
    }

    /**
     * orders getter
     * @return orders
     */
    public int getOrders() {
        return orders;
    }

    /**
     * delivered orders getter
     * @return delivered orders
     */
    public int getDelivered_orders() {
        return delivered_orders;
    }

    /**
     * processed orders getter
     * @return processed orders
     */
    public int getProcessed_orders() {
        return processed_orders;
    }
}
