package ru.astondev.lesson7.task2;
// Класс Triangle (Треугольник) который наследуется от класса BaseShape.
// Переопределяются основные методы getPerimeter и getArea под специфику фигуры
public class Triangle extends BaseShape{
    // Объявляем три переменные типа double для задания размера трём сторонам треугольника
    private double sideA;
    private double sideB;
    private double sideC;

    // Конструктор для инициализации значений
    public Triangle(String fillColor, String borderColor, double sideA, double sideB, double sideC) {
        super(fillColor, borderColor);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Переопределённый get метод возвращения значения периметра треугольника
    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    // Переопределённый get метод возвращения значения параметра площади треугольника
    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s-sideC));
    }
}
