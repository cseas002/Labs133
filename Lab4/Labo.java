package Lab4;

public class Labo {
    public static void main(String[] args) {
        Mouse s1 = new Mouse(50, "white", 2);
        Mouse s2 = new Mouse(45, "gray");
        Mouse s3 = new Mouse(s2);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        s1.evolution();
        s2.evolution();
        s3.evolution();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}