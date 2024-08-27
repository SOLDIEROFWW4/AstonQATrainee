package ru.astondev.lesson8;

// Создаём класс исключения размерности массива
public class MyArraySizeException extends Exception {
    // Создаём конструктор и передаём ему в качестве параметра переменную String для вывода сообщения об ошибке
    public MyArraySizeException(String message) {
        super(message);
    }
}
