package ru.astondev.lesson7;

public class Cat extends Animal{
    static int totalCats = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean satiety;


    public Cat(String name) {
        super(name);
        this.satiety = false;
        totalCats++;
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }

    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }
}
