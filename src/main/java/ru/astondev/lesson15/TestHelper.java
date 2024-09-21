package ru.astondev.lesson15;

import org.openqa.selenium.WebElement;

public class TestHelper {
    public static void assertTextEquals(String expected, String actual, String errorMessage) {
        if (!expected.equals(actual)) {
            throw new AssertionError(errorMessage + ": ожидалось [" + expected + " ], но найдено [" + actual + " ]");
        } else {
            System.out.println("Тест пройден успешно. Текст соответствует ожидаемому результату.");
        }
    }

    public static void assertElementDisplayed(WebElement element, String errorMessage) {
        if (!element.isDisplayed()) {
            throw new AssertionError(errorMessage);
        } else {
            System.out.println("Тест пройден успешно. Элемент отображается.");
        }
    }
}
