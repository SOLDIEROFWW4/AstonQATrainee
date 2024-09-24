package ru.astondev.lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class FormValidator {
    private WebDriver webDriver;

    public FormValidator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private Map<String, String[]> fieldXPaths = new HashMap<>();

    {
        fieldXPaths.put("Услуги связи", new String[]{
                "//div[2]/form[1]/div[1]/input",
                "//div[2]/form[1]/div[2]/input",
                "//div[2]/form[1]/div[3]/input]"
        });
        fieldXPaths.put("Домашний интернет", new String[]{
                "//div[2]/form[2]/div[1]/input",
                "//div[2]/form[2]/div[2]/input",
                "//div[2]/form[2]/div[3]/input"
        });
        fieldXPaths.put("Рассрочка", new String[]{
                "//div[2]/form[3]/div[1]/input",
                "//div[2]/form[3]/div[2]/input",
                "//div[2]/form[3]/div[3]/input"
        });
        fieldXPaths.put("Задолженность", new String[]{
                "//div[2]/form[4]/div[1]/input",
                "//div[2]/form[4]/div[2]/input",
                "//div[2]/form[4]/div[3]/input"
        });
    }

    public void validateFormFields(String optionText) {
        String[] ids = fieldXPaths.get(optionText);
        if (ids == null) {
            throw new NullPointerException("Идентификаторы не найдены для опции: " + optionText);
        }

        WebElement phoneInput = webDriver.findElement(By.xpath(ids[0]));
        WebElement sumInput = webDriver.findElement(By.xpath(ids[1]));
        WebElement emailInput = webDriver.findElement(By.xpath(ids[2]));

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
