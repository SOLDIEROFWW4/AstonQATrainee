package ru.astondev.lesson7.task1;

// Создаём абстрактный класс для животных
public abstract class Animal {
    // Объявляем переменные для подсчёта количества животных и для объявления их имён
    static int totalAnimals = 0;
    protected String name;

    // Создаём конструктор для инициализации значений
    public Animal(String name) {
        this.name = name;
        totalAnimals++;
    }

    // Создаём метод для общей логики поведения животных: бега и плаванья
    // передаём туда переменную типа int для дистанции в качестве параметра
    public abstract void run(int distance);

    public abstract void swim(int distance);

    // get метод для возвращения значения имени животного
    public String getName() {
        return name;
    }
}
