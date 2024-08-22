package ru.astondev.lesson7;

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
    }
}
