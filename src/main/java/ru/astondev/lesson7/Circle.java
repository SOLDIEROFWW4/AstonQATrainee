package ru.astondev.lesson7;

public class Circle extends BaseShape{
    private double radius;

    public Circle(String fillColor, String borderColor) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
