package lesson15;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.astondev.lesson15.TestHelper;

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
    }


    @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
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
        assertTrue(paymentVerifiedByVisaLogo.isDisplayed());
    }

    @Test
    public void testPaymentMastercardLogo() {
        WebElement paymentMastercardLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[3]"));
        assertTrue(paymentMastercardLogo.isDisplayed());
    }

    @Test
    public void testPaymentMastercardSecureCodeLogo() {
        WebElement paymentMastercardSecureCodeLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[4]"));
        assertTrue(paymentMastercardSecureCodeLogo.isDisplayed());
    }

    @Test
    public void testPaymentBelcardLogo() {
        WebElement paymentBelcardLogo = webDriver.findElement(new By.ByXPath("//section/div/div[2]/ul/li[5]"));
        assertTrue(paymentBelcardLogo.isDisplayed());
    }

    @Test
    public void testLearnMoreLink() {
        WebElement learnMoreLinks = webDriver.findElement(new By.ByXPath("//div[2]/section/div/a"));
        learnMoreLinks.click();
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", webDriver.getCurrentUrl());
    }

    @Test
    public void testContinueButton() {
        WebElement paymentSection = webDriver.findElement(new By.ByXPath("//div[2]/section"));
        
    }
}
