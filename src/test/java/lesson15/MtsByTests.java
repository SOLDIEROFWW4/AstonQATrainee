package lesson15;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class MtsByTests {

    private WebDriver webDriver;
    private final static String path = "https://www.mts.by/";

    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
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
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle.getText());
    }

    @Test
    public void testPaymentVisaLogo() {
        WebElement paymentVisaLogo = webDriver.findElement(new By.ByXPath(""));
        assertTrue(paymentVisaLogo.isDisplayed());
    }

    @Test
    public void testPaymentVerifiedByVisaLogo() {
        WebElement paymentVerifiedByVisaLogo = webDriver.findElement(new By.ByXPath(""));
        assertTrue(paymentVerifiedByVisaLogo.isDisplayed());
    }

    @Test
    public void testPaymentMastercardLogo() {
        WebElement paymentMastercardLogo = webDriver.findElement(new By.ByXPath(""));
        assertTrue(paymentMastercardLogo.isDisplayed());
    }

    @Test
    public void testPaymentMastercardSecureCodeLogo() {
        WebElement paymentMastercardSecureCodeLogo = webDriver.findElement(new By.ByXPath(""));
        assertTrue(paymentMastercardSecureCodeLogo.isDisplayed());
    }

    @Test
    public void testPaymentBelcardLogo() {
        WebElement paymentBelcardLogo = webDriver.findElement(new By.ByXPath(""));
        assertTrue(paymentBelcardLogo.isDisplayed());
    }
}
