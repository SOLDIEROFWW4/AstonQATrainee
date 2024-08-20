package ru.astondev.lesson6;

public class Main {
    public static void main(String[] args) {
        // Объявляем массив типа Employee на пять элементов.
        Employee[] employeesArray = new Employee[5];

        // Заполняем массив employeesArray 5 элементами
        employeesArray[0] = new Employee("Ivan Ivanov", "Engineer", "iivan@yahoo.eu", "892312312", 30000, 30);
        employeesArray[1] = new Employee("Petr Petrov", "Manager", "ppetrov@gmail.com", "893312312", 40000, 35);
        employeesArray[2] = new Employee("Svetlana Smirnova", "Accountant", "ssmirnova@mail.ru", "894412312", 35000, 40);
        employeesArray[3] = new Employee("Olga Ivanova", "Designer", "oivanova@design.com", "895512312", 32000, 28);
        employeesArray[4] = new Employee("Sergey Sidorov", "Developer", "ssidorov@dev.com", "896612312", 45000, 25);

        // В данном цикле for проходим по всем элементам массива employeesArray
        // вызываем метод printInfo() для вывода элементов массива employeesArray
        // Отделяем каждый элемент массива пустой строкой при помощи System.out.println();
        for (Employee employee : employeesArray) {
            employee.printInfo();
            System.out.println();
        }

        // Создаём экземпляр класса Park и задаём название парку Example Park
        Park park = new Park("Example Park");
        // Создаём экземпляр внутреннего класса Attraction и инициализируем его
        Park.Attraction rollerCoaster = park.new Attraction("Roller Coaster", "12:00", "19:00", 10);
        Park.Attraction ferrisWheel = park.new Attraction("Ferris Wheel", "14:00", "20:00", 20);

        // Выводим информацию о rollerCoaster
        rollerCoaster.printInfo();
        System.out.println();
        // Выводим информацию о ferrisWheel
        ferrisWheel.printInfo();
    }
}
