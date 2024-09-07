package ru.astondev.lesson11.task2;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        contacts.computeIfAbsent(lastName, k-> new ArrayList<>()).add(phoneNumber);
    }

    public List<String> get(String lastName) {
        return contacts.getOrDefault(lastName, Collections.emptyList());
    }
}
