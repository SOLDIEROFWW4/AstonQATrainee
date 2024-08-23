package ru.astondev.lesson7.task2;

public class Rectangle extends BaseShape{
    private double width;
    private double height;

    public Rectangle(String fillColor, String borderColor, double width, double height) {
        super(fillColor, borderColor);
        this.height = height;
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2 + (width * height);
    }

    @Override
    public double getArea() {
        return width * height;
    }
}
