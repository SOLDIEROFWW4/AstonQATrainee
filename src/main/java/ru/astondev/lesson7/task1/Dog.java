package ru.astondev.lesson7.task1;
// Класс Dog (Собака) который наследуется от класса Animal (Животное)
// Переопределяются основные методы run и swim под специфику логики поведения животного (по ТЗ)
public class Dog extends Animal{
    // Переменная для подсчёта количества котов, переменная для максимальной дистанции пробежки и плаванья.
    static int totalDogs = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    // Конструкция для инициализации переменных
    public Dog(String name) {
        super(name);
        totalDogs++;
    }

    // Переопределённый метод для логики поведения собаки при беге
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }

    // Переопределённый метод для логики поведения собаки при плаванье (собака может плавать по ТЗ)
    @Override
    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }
}
