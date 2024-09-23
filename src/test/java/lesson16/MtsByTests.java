package lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MtsByTests {

    private WebDriver webDriver;
    private static final String path = "https://www.mts.by/";


    @BeforeEach
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
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
    public void testPaymentServicesDropdownOptions() {
        WebElement paymentSection = webDriver.findElement(new By.ByXPath("//div/div[2]/section/div"));
        scrollToElement(paymentSection);
        WebElement dropdownButton = webDriver.findElement(new By.ByXPath("//section/div/div[1]/div[1]/div[2]/button"));
        dropdownButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//section/div/div[1]/div[1]/div[2]/ul")));

        List<WebElement> options = webDriver.findElements(By.xpath("//li[@class='select__item']/p[@class='select__option']"));
        System.out.println("Количество опций: " + options.size());

        for (int i = 0; i < options.size(); i++) {
            options = webDriver.findElements(By.xpath("//li[@class='select__item']/p[@class='select__option']"));
            WebElement option = options.get(i);
            System.out.println("Опция: " + option.getText());

            try {
                scrollToElement(option);
                option.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", option);
            }

            // Открываем выпадающий список снова
            dropdownButton.click();
        }
    }
}
