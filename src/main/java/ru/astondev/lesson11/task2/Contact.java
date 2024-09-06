package ru.astondev.lesson11.task2;

import java.util.*;

public class Contact {
    private String lastName;
    private List<String> phoneNumbers;

    public Contact(String lastName) {
        this.lastName = lastName;
        this.phoneNumbers = new ArrayList<>();
    }

    public void addPhoneNumber(String phoneNumber) {
        phoneNumbers.add(phoneNumber);
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getLastName() {
        return lastName;
    }
}
