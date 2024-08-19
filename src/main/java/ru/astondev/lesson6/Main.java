package ru.astondev.lesson6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new Employee("Ivan Ivanov", "Engineer", "iivan@yahoo.eu", "892312312", 30000, 30);
        employees[1] = new Employee("Petr Petrov", "Manager", "ppetrov@gmail.com", "893312312", 40000, 35);
        employees[2] = new Employee("Svetlana Smirnova", "Accountant", "ssmirnova@mail.ru", "894412312", 35000, 40);
        employees[3] = new Employee("Olga Ivanova", "Designer", "oivanova@design.com", "895512312", 32000, 28);
        employees[4] = new Employee("Sergey Sidorov", "Developer", "ssidorov@dev.com", "896612312", 45000, 25);

        for (Employee employee : employees) {
            employee.printInfo();
            System.out.println();
        }
    }
}
