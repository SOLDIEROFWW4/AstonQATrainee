package ru.astondev.lesson11.task1;

import java.util.*;

public class WordProcessor {
    private String[] words;

    public WordProcessor(String[] words) {
        this.words = words;
    }

    public Set<String> getUniqueWords() {
        return new HashSet<>(Arrays.asList(words));
    }

    public Map<String, Integer> getWordFrequencies() {
        Map<String,Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }
}
