package ru.astondev.lesson7.task2;
// Класс Rectangle (Прямоугольник) который наследуется от класса BaseShape.
// Переопределяются основные методы getPerimeter и getArea под специфику фигуры
public class Rectangle extends BaseShape{
    // Объявляем две переменные типа double для высоты и ширины прямоугольника
    private double width;
    private double height;

    // Конструктор для инициализации значений
    public Rectangle(String fillColor, String borderColor, double width, double height) {
        super(fillColor, borderColor);
        this.height = height;
        this.width = width;
    }

    // Переопределённый get метод возвращения значения периметра прямоугольника
    @Override
    public double getPerimeter() {
        return 2 + (width * height);
    }

    // Переопределённый get метод возвращения значения площади прямоугольника
    @Override
    public double getArea() {
        return width * height;
    }
}
