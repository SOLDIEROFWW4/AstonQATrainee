package ru.astondev.lesson16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormValidator {
    private WebDriver webDriver;

    public FormValidator(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void validateFormFields() {
        WebElement phoneInput = webDriver.findElement(By.id("internet-phone"));
        WebElement sumInput = webDriver.findElement(By.id("internet-sum"));
        WebElement emailInput = webDriver.findElement(By.id("internet-email"));

        TestHelper.assertElementDisplayed(phoneInput, "Поле 'Номер абонента' не отображается");
        TestHelper.assertElementDisplayed(sumInput, "Поле 'Сумма' не отображается");
        TestHelper.assertElementDisplayed(emailInput, "Поле 'E-mail для отправки чека' не отображается");

        TestHelper.assertTextEquals("Номер абонента", phoneInput.getAttribute("placeholder"), "Неверный плейсхолдер для 'Номер абонента'");
        TestHelper.assertTextEquals("Сумма", sumInput.getAttribute("placeholder"), "Неверный плейсхолдер для 'Сумма'");
        TestHelper.assertTextEquals("E-mail для отправки чека", emailInput.getAttribute("placeholder"), "Неверный плейсхолдер для 'E-mail для отправки чека'");
    }
}
