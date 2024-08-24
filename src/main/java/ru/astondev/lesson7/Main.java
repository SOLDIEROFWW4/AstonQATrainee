package ru.astondev.lesson7;

import ru.astondev.lesson7.task1.Bowl;
import ru.astondev.lesson7.task1.Cat;
import ru.astondev.lesson7.task2.Circle;
import ru.astondev.lesson7.task2.Rectangle;
import ru.astondev.lesson7.task2.Shape;
import ru.astondev.lesson7.task2.Triangle;

public class Main {
    public static void main(String[] args) {
       Cat[] cats = { new Cat("Снежок"), new Cat("Барсик"), new Cat("Марс")};

        Bowl bowl = new Bowl(20);

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }

        bowl.addFood(30);

        /*Shape circle = new Circle("Black", "Red", 5);
        Shape rectangle = new Rectangle("Blue", "Yellow",4 ,6 );
        Shape triangle = new Triangle("Green", "Purple", 5, 4,6 );

        circle.printDetails();
        rectangle.printDetails();
        triangle.printDetails();*/
    }
}
