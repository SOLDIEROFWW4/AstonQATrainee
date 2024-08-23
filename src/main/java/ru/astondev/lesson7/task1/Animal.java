package ru.astondev.lesson7.task1;

public abstract class Animal {
    static int totalAnimals = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public String getName() {
        return name;
    }
}
