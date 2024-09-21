package lesson15;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.astondev.lesson15.TestHelper;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class MtsByTests {

    private WebDriver webDriver;
    private final static String path = "https://www.mts.by/";

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        webDriver.get(path);
        handleCookiePopup();
    }


    @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public void handleCookiePopup() {
        try {
            WebElement cookieButton = webDriver.findElement(By.xpath("//div/div[2]/button[3]"));
            if (cookieButton.isDisplayed()) {
                cookieButton.click();
                System.out.println("Cookie окно найдено и закрыто.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cookie окно не найдено. Продолжаем выполнение тестов.");
        }
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = webDriver.findElement(new By.ByXPath("/html/body//div/div/div[2]/section/div/h2"));
        TestHelper.assertTextEquals("Онлайн пополнение\nбез комиссии", blockTitle.getText(), "Заголовок блока не соответствует ожидаемому");
    }

    @Test
    public void testPaymentVisaLogo() {
        WebElement paymentVisaLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[1]"));
        TestHelper.assertElementDisplayed(paymentVisaLogo, "Логотип платёжной системы Visa не отображается");
    }

    @Test
    public void testPaymentVerifiedByVisaLogo() {
        WebElement paymentVerifiedByVisaLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[2]"));
        TestHelper.assertElementDisplayed(paymentVerifiedByVisaLogo, "Логотип платёжной системы Verified By Visa не отображается");
    }

    @Test
    public void testPaymentMastercardLogo() {
        WebElement paymentMastercardLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[3]"));
        TestHelper.assertElementDisplayed(paymentMastercardLogo, "Логотип платёжной системы Mastercard не отображается");
    }

    @Test
    public void testPaymentMastercardSecureCodeLogo() {
        WebElement paymentMastercardSecureCodeLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[4]"));
        TestHelper.assertElementDisplayed(paymentMastercardSecureCodeLogo, "Логотип платёжной системы Mastercard Secure не отображается");
    }

    @Test
    public void testPaymentBelcardLogo() {
        WebElement paymentBelcardLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[5]"));
        TestHelper.assertElementDisplayed(paymentBelcardLogo, "Логотип платёжной системы Belcard не отображается");
    }

    @Test
    public void testLearnMoreLink() {
        WebElement learnMoreLinks = webDriver.findElement(new By.ByXPath("//div[2]/section/div/a"));
        scrollToElement(learnMoreLinks);
        learnMoreLinks.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", webDriver.getCurrentUrl());
    }

    @Test
    public void testPaymentSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        WebElement paymentSection = webDriver.findElement(new By.ByXPath("//div/div[2]/section/div"));
        scrollToElement(paymentSection);

        WebElement phoneNumberField = webDriver.findElement(new By.ByXPath("//div[2]/form[1]/div[1]/input"));
        phoneNumberField.sendKeys("297777777");

        WebElement paymentField = webDriver.findElement(new By.ByXPath("//div[2]/form[1]/div[2]/input"));
        paymentField.sendKeys("5");

        WebElement emailField = webDriver.findElement(new By.ByXPath("//div[2]/form[1]/div[3]/input"));
        emailField.sendKeys("example@gmail.com");

        WebElement continueButton = webDriver.findElement(new By.ByXPath("//div[2]/form[1]/button"));
        continueButton.click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(new By.ByXPath("/html/body/div[8]/div/iframe")));

        System.out.println("Фрейм оплаты успешно загружен");

        webDriver.switchTo().defaultContent();

    }
}
