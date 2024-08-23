package ru.astondev.lesson7.task2;

abstract class BaseShape implements Shape {
   private String fillColor;
   private String borderColor;

   public BaseShape(String fillColor, String borderColor) {
       this.fillColor = fillColor;
       this.borderColor = borderColor;
   }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
       return borderColor;
    }

    @Override
    public void printDetails() {
        System.out.println("Периметр: " + getPerimeter());
        System.out.println("Площадь: " + getArea());
        System.out.println("Цвет заливки: " + getFillColor());
        System.out.println("Цвет границы: " + getBorderColor());
        System.out.println();
    }
}
