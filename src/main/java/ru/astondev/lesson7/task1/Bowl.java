package ru.astondev.lesson7.task1;
// Создаём класс Bowl (Миска)
public class Bowl {
    // Объявляем переменную food типа int для количества еды.
    private int food;

    // Конструктор для инициализации переменной food
    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    // get для возвращения значения переменной food
    public int getFood() {
        return food;
    }

    // Метод для добавления еды в миску. Переменная amount отвечает за количество добавляемой еды
    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
        }
    }

    // Метод для удаления еды из миски при поглощении её котами
    // Переменная amount отвечает за количество добавляемой еды
    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }
}
