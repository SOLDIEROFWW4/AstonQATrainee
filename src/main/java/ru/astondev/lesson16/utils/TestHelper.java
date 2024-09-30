package ru.astondev.lesson16.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
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

    // Метод для принятия условий Cookie
    public static void handleCookiePopup(WebDriver webDriver) {
        try {
            WebElement cookieButton = webDriver.findElement(By.xpath("//button[@id='cookie-agree']"));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
                System.out.println("Cookie окно найдено и закрыто.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cookie окно не найдено. Продолжаем выполнение тестов.");
        }
    }
}
