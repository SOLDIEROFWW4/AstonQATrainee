package ru.astondev.lesson16.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.astondev.lesson16.utils.TestHelper;

import java.time.Duration;

public class PaymentPage {
    private WebDriver webDriver;

    public PaymentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillPaymentForm(String phone, String sum, String email) {
        webDriver.findElement(By.xpath("//input[@id='connection-phone']")).sendKeys(phone);
        webDriver.findElement(By.xpath("//input[@id='connection-sum']")).sendKeys(sum);
        webDriver.findElement(By.xpath("//input[@id='connection-email']")).sendKeys(email);
        webDriver.findElement(By.xpath("//button[text()='Продолжить']")).click();
    }

    public void switchToPaymentFrameAndValidate() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));

        System.out.println("Фрейм оплаты успешно загружен");

        WebElement amountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__cost']")));
        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']")));

        TestHelper.assertTextEquals("5.00 BYN", amountElement.getText(), "Некорректная сумма в окне оплаты");
        TestHelper.assertTextEquals("Оплата: Услуги связи Номер:375297777777", phoneElement.getText().trim(), "Некорректный номер телефона в окне оплаты");

        WebElement cardNumberField = webDriver.findElement(By.xpath("//input[@formcontrolname='creditCard']"));
        WebElement cardHolderField = webDriver.findElement(By.xpath("//input[@formcontrolname='holder']"));
        WebElement expirationField = webDriver.findElement(By.xpath("//input[@formcontrolname='expirationDate']"));
        WebElement cvcField = webDriver.findElement(By.xpath("//input[@formcontrolname='cvc']"));
        WebElement paymentSystemIcons = webDriver.findElement(By.xpath("//app-input/div/div/div[2]/div/div"));

        TestHelper.assertElementDisplayed(cardNumberField, "Поле ввода номера карты не отображается");
        TestHelper.assertElementDisplayed(cardHolderField, "Поле ввода имени владельца карты не отображается");
        TestHelper.assertElementDisplayed(expirationField, "Поле ввода срока действия карты не отображается");
        TestHelper.assertElementDisplayed(cvcField, "Поле ввода CVC не отображается");
        TestHelper.assertElementDisplayed(paymentSystemIcons, "Иконки платёжных систем не отображаются");

        webDriver.switchTo().defaultContent();
    }
}
