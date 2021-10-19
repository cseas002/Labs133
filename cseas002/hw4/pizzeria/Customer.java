package cseas002.hw4.pizzeria;

/**
 * @author Christoforos Seas 1028675
 * Customer class
 */

public class Customer {
    private String name;
    private final int money = 5 + Driver.RANDOM.nextInt(30);
    private final Order order;

    /**
     * name getter
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * money getter
     * @return Customer's money
     */
    public int getMoney() {
        return money;
    }

    /**
     * order getter
     * @return Customer's order
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Constructor
     * @param order Customer's order
     */
    public Customer(Order order) {
        this.order = order;
    }
}
