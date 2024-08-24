package ru.astondev.lesson7.task2;

// Создаём интерфейс Shape, задающий методы для расчета периметра и площади фигур, а также получения цветов;
public interface Shape {
    double getPerimeter();
    double getArea();
    String getFillColor();
    String getBorderColor();
    void printDetails();
}
