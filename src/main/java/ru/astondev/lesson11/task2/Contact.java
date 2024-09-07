package ru.astondev.lesson11.task2;

import java.util.*;

public class Contact {
    // Переменная lastName типа String для
    private String lastName;
    // List для хранения телефонных номеров контакта
    private List<String> phoneNumbers;

    // Конструктор класса для инициализации значений
    public Contact(String lastName) {
        // Инициализируем поле lastName переданной фамилией
        this.lastName = lastName;
        // Инициализируем пустой List для хранения телефонных номеров
        this.phoneNumbers = new ArrayList<>();
    }

    // Метод для добавления телефонного номера
    public void addPhoneNumber(String phoneNumber) {
        // Добавляем переданный номер в список phoneNumbers
        phoneNumbers.add(phoneNumber);
    }

    // Метод для получения всех телефонных номеров
    public List<String> getPhoneNumbers() {
        // Возвращаем список телефонных номеров
        return phoneNumbers;
    }

    // Метод для получения фамилии контакта
    public String getLastName() {
        // Возвращаем фамилию
        return lastName;
    }
}
