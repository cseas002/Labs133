package Lab12;

public class TestRectangles {
    public static void main(String[] args) {
        System.out.println("Test 1 :");
        Rectangle rect = new Rectangle(12.5, 4.0);
        System.out.println(rect);
        System.out.println();

        System.out.println("Test 2: ");
        // the type of rect1 is ColoredRectangle
        // the object contained in rect1 is of type ColoredRectangle
        ColoredRectangle rect1 = new ColoredRectangle(12.5, 4.0, "red");
        System.out.println(rect1);
        System.out.println();

        System.out.println("Test 3 :");
        // the type of rect2 is Rectangle
        // the object contained in rect2 is of type ColoredRectangle
        Rectangle rect2 = new ColoredRectangle(25.0/2, 8.0 / 2, new String("red"));
        System.out.println(rect2);
        System.out.println(rect1.equals(rect2)); // 1.
        System.out.println(rect2.equals(rect1)); // 2.
        System.out.println(rect1.equals(null)); // 3.
        System.out.println(rect.equals(rect1)); // 4.
        System.out.println(rect1.equals(rect)); // 5.
    }
}