package ru.astondev.lesson7;

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
}
