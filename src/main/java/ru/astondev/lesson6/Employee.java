package ru.astondev.lesson6;
// Создаём класс Сотрудники (Employee)
public class Employee {
    // Создаём 6 переменных для ФИО, должности, эл. почты, номера телефона, заработной платы и возраста сотрудника.
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    // Создаём конструктор для инициализации этих 6 переменных
    public Employee(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // Метод printInfo() служит для вывода переменных в список.
    public void printInfo() {
        System.out.println("ФИО: " + fullName);
        System.out.println("Должность: " + position);
        System.out.println("Email: " + email);
        System.out.println("Телефон: " + phone);
        System.out.println("Зарплата: " + salary + "₽");
        System.out.println("Возраст: " + age);
    }
}
