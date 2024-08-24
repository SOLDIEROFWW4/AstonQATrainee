package ru.astondev.lesson7.task2;
// Класс Circle (Круг) который наследуется от класса BaseShape.
// Переопределяются основные методы getPerimeter и getArea под специфику фигуры
public class Circle extends BaseShape{
    // Объявляем переменную типа double для радиуса круга
    private double radius;

    // Конструктор для инициализации значений
    public Circle(String fillColor, String borderColor, double radius) {
        super(fillColor, borderColor);
        this.radius = radius;
    }

    // Переопределённый get метод возвращения значения периметра круга
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Переопределённый get метод возвращения значения параметра площади круга
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
