package ru.astondev.lesson16.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class FormValidator {
    private final WebDriver webDriver;

    public FormValidator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private Map<String, String[]> fieldXPaths = new HashMap<>();

    {
        fieldXPaths.put("Услуги связи", new String[]{
                "//input[@id='connection-phone']",
                "//input[@id='connection-sum']",
                "//input[@id='connection-email']"
        });
        fieldXPaths.put("Домашний интернет", new String[]{
                "//input[@id='internet-phone']",
                "//input[@id='internet-sum']",
                "//input[@id='internet-email']"
        });
        fieldXPaths.put("Рассрочка", new String[]{
                "//input[@id='score-instalment']",
                "//input[@id='instalment-sum']",
                "//input[@id='instalment-email']"
        });
        fieldXPaths.put("Задолженность", new String[]{
                "//input[@id='score-arrears']",
                "//input[@id='arrears-sum']",
                "//input[@id='arrears-email']"
        });
    }

    public void validateFormFields(String optionText) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        String[] ids = fieldXPaths.get(optionText);
        if (ids == null) {
            throw new NullPointerException("Идентификаторы не найдены для опции: " + optionText);
        }

        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ids[0])));
        WebElement sumInput  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ids[1])));
        WebElement emailInput  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ids[2])));

        TestHelper.assertElementDisplayed(phoneInput, "Поле 'Номер' не отображается");
        TestHelper.assertElementDisplayed(sumInput, "Поле 'Сумма' не отображается");
        TestHelper.assertElementDisplayed(emailInput, "Поле 'E-mail для отправки чека' не отображается");

        String expectedPhonePlaceholder = "Номер абонента";
        if ("Рассрочка".equals(optionText)) {
            expectedPhonePlaceholder = "Номер счета на 44";
        } else if ("Задолженность".equals(optionText)) {
            expectedPhonePlaceholder = "Номер счета на 2073";
        }

        TestHelper.assertTextEquals(expectedPhonePlaceholder, phoneInput.getAttribute("placeholder"), "Неверный плейсхолдер для 'Номер'");
        TestHelper.assertTextEquals("Сумма", sumInput.getAttribute("placeholder"), "Неверный плейсхолдер для 'Сумма'");
        TestHelper.assertTextEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"), "Неверный плейсхолдер для 'E-mail для отправки чека'");
    }
}
