package ru.astondev.lesson11.task2;

import java.util.*;

public class PhoneBook {
    // Поле для хранения контактов, где ключ - фамилия, значение - список телефонных номеров
    private Map<String, List<String>> contacts;

    // Конструктор класса для инициализации значений
    public PhoneBook() {
        // Инициализируем поле contacts пустой HashMap
        contacts = new HashMap<>();
    }

    // Метод для добавления телефонного номера по фамилии
    public void add(String lastName, String phoneNumber) {
        // Если фамилия отсутствует, создаем новый список, затем добавляем номер
        contacts.computeIfAbsent(lastName, k-> new ArrayList<>()).add(phoneNumber);
    }

    // Метод для получения списка телефонных номеров по фамилии
    public List<String> get(String lastName) {
        // Возвращаем список номеров для данной фамилии или пустой список, если фамилия отсутствует
        return contacts.getOrDefault(lastName, Collections.emptyList());
    }
}
