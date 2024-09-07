package ru.astondev.lesson11.task1;

import java.util.*;

public class WordProcessor {
    // Объявляем массив word типа String для хранения слов
    private String[] words;

    // Конструктор класса для инициализации значений массива words
    public WordProcessor(String[] words) {
        this.words = words;
    }

    // Метод для получения уникальных слов из массива
    public Set<String> getUniqueWords() {
        // Преобразуем массив words в список, а потом в HashSet для получения ТОЛЬКО уникальных слов
        return new HashSet<>(Arrays.asList(words));
    }

    // Метод для подсчёта количества каждого слова в массиве
    public Map<String, Integer> getWordFrequencies() {
        // Объявляем Map для хранения количества вхождений каждого слова
        Map<String,Integer> wordCount = new HashMap<>();
        // Проходим по каждому слову в массиве words
        for (String word : words) {
            // Обновляем количество вхождений текущего слова в Map
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        // Возвращаем Map с частотой встречаемости слов
        return wordCount;
    }
}
