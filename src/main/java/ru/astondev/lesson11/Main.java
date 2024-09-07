package ru.astondev.lesson11;

import ru.astondev.lesson11.task1.WordProcessor;
import ru.astondev.lesson11.task2.PhoneBook;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /* String[] words = {
                "apple", "banana", "apple", "orange", "banana",
                "kiwi", "apple", "pear", "kiwi", "banana"
        };

        WordProcessor processor = new WordProcessor(words);

        System.out.println("Уникальные слова:");
        for (String word : processor.getUniqueWords()) {
            System.out.println(word);
        }

        System.out.println("\nЧастота встречаемости слов:");
        for (Map.Entry<String, Integer> entry : processor.getWordFrequencies().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " раз(а)");
        } */

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "123-456");
        phoneBook.add("Petrov", "234-567");
        phoneBook.add("Ivanov", "345-678");

        System.out.println("Номера Ивановых: " + phoneBook.get("Ivanov"));
        System.out.println("Номера Петровых: " + phoneBook.get("Petrov"));
    }
}
