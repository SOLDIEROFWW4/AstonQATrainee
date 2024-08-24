package ru.astondev.lesson7.task2;

// Создаём абстрактный класс BaseShape, реализующий общие свойства и методы, такие как цвета заливки и границы;
abstract class BaseShape implements Shape {
   // Объявляем переменные типа String для обозначения цвета заполнения самой фигуры и её границ
   private String fillColor;
   private String borderColor;

   // Конструктор для инициализации переменной
   public BaseShape(String fillColor, String borderColor) {
       this.fillColor = fillColor;
       this.borderColor = borderColor;
   }

   // Переопределённый get метод возвращения значения цвета заливки границ фигуры
    @Override
    public String getFillColor() {
        return fillColor;
    }

    // Переопределённый get метод возвращения значения цвета заливки фигуры
    @Override
    public String getBorderColor() {
       return borderColor;
    }

    // Переопределённый метод для вывода параметров фигуры
    @Override
    public void printDetails() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
