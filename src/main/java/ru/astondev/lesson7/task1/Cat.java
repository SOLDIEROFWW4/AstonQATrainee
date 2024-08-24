package ru.astondev.lesson7.task1;
// Класс Cat (Кот) который наследуется от класса Animal (Животное)
// Переопределяются основные методы run и swim под специфику логики поведения животного (по ТЗ)
public class Cat extends Animal{
    // Переменная для подсчёта количества котов, переменная для максимальной дистанции пробежки и переменная для сытости.
    static int totalCats = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean satiety;

    // Конструктор для инициализации переменных
    public Cat(String name) {
        super(name);
        this.satiety = false;
        totalCats++;
    }

    // Переопределённый метод run для логики поведения бега кошки, в зависимости от дистанции (ПО ТЗ)
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }

    }
    // Переопределённый метод swim для логики поведения плаванья кошки, кошка не плавает (ПО ТЗ)
    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }

    // Метод для поедания еды из миски
    public void eat(Bowl bowl, int foodAmount) {
        if (bowl.getFood() >= foodAmount) {
            bowl.decreaseFood(foodAmount);
            setSatiety(true);
            System.out.println(getName() + " теперь сыт.");
        } else {
            System.out.println(getName() + " не хватило еды.");
        }
    }


    // get метод возращения значения переменной satiety
    public boolean isSatiety() {
        return satiety;
    }

    // set метод для изменения значения переменной satiety
    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }
}
