package ru.astondev.lesson7.task1;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
        }
    }

    public void decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
        }
    }
}
