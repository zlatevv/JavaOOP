package Polymorphism.Shapes;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
