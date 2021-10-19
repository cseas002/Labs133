package frontistiria;

public class PizzaMaker {
    public static void main(String[] args) {
// The frontistiria.PlainPizza object is sent to the frontistiria.Mozzarella constructor
// and then to the frontistiria.TomatoSauce constructor
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println("Ingredients: " + basicPizza.getDescription());
        System.out.println("Price: " + basicPizza.getTotalCost());
    }
}