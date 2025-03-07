package Polymorphism.Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    protected Double calculatePerimeter() {
        return Math.PI * radius * 2;
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * radius * radius;
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
