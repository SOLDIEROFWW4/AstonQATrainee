package ru.astondev.lesson8;

// Создаём класс исключения для преобразования массива тип int и суммирования его элементов
public class MyArrayDataException extends Exception {
    // Создаём конструктор и передаём ему в качестве параметра переменную String для вывода сообщения об ошибке
    public MyArrayDataException(String message) {
        super(message);
    }
}
