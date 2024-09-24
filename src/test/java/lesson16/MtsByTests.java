package lesson16;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.astondev.lesson16.FormValidator;
import ru.astondev.lesson16.TestHelper;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MtsByTests {

    private WebDriver webDriver;
    private FormValidator formValidator = new FormValidator(webDriver);
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

    // Метод для принятия условий Cookie
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

    // Метод для прокрутки к форме оплаты услуг.
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Тест для проверки всех элементов выпадающего списка
    @Test
    public void testPaymentServicesDropdownOptions() {
        WebElement paymentSection = webDriver.findElement(By.xpath("//div/div[2]/section/div"));
        scrollToElement(paymentSection);
        WebElement dropdownButton = webDriver.findElement(By.xpath("//section/div/div[1]/div[1]/div[2]/button"));
        dropdownButton.click();

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section/div/div[1]/div[1]/div[2]/ul")));

        List<WebElement> options = webDriver.findElements(By.xpath("//li[@class='select__item']/p[@class='select__option']"));
        System.out.println("Количество опций: " + options.size());

        FormValidator formValidator = new FormValidator(webDriver);

        for (int i = 0; i < options.size(); i++) {
            options = webDriver.findElements(By.xpath("//li[@class='select__item']/p[@class='select__option']"));
            WebElement option = options.get(i);
            String optionText = option.getText();
            System.out.println("Опция: " + optionText);

            try {
                scrollToElement(option);
                option.click();
            } catch (ElementClickInterceptedException e) {
                ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", option);
            }

            // Проверка полей формы
            formValidator.validateFormFields(optionText);

            // Открываем выпадающий список снова
            dropdownButton.click();

            // Ожидание, чтобы убедиться, что список снова стал видимым
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='select__item']/p[@class='select__option']")));
        }
    }

    // ТЕСТ РАБОТАЕТ ЛИШЬ В DEBUG!!! ПОМОГИТЕ ПОЖАЛУЙСТА РАЗОБРАТЬСЯ, ЧТО НЕ ТАК!!!
    // Тест для заполнения полей формы оплаты услуг реквизитами и переход на iframe с проверкой его полей.
    @Test
    public void testPaymentSection() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        // Поиск формы услуг и скроллинг на неё
        WebElement paymentSection = webDriver.findElement(By.xpath("//div/div[2]/section/div"));
        scrollToElement(paymentSection);

        // Заполнение полей формы оплаты услуг реквизитами, данными по прошлому ТЗ
        WebElement phoneNumberField = webDriver.findElement(By.xpath("//div[2]/form[1]/div[1]/input"));
        phoneNumberField.sendKeys("297777777");

        WebElement paymentField = webDriver.findElement(By.xpath("//div[2]/form[1]/div[2]/input"));
        paymentField.sendKeys("5");

        WebElement emailField = webDriver.findElement(By.xpath("//div[2]/form[1]/div[3]/input"));
        emailField.sendKeys("example@gmail.com");

        WebElement continueButton = webDriver.findElement(By.xpath("//div[2]/form[1]/button"));
        continueButton.click();

        // Ожидание и переключение на iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("/html/body/div[8]/div/iframe")));

        System.out.println("Фрейм оплаты успешно загружен");

        // Поиск элементов в iframe
        WebElement amountElement = webDriver.findElement(By.xpath("//app-payment-container/section/div/div/div[1]"));
        WebElement phoneElement = webDriver.findElement(By.xpath("//app-payment-container/section/div/div/div[2]"));

        // Проверка данных в полях
        TestHelper.assertTextEquals("5.00 BYN", amountElement.getText(), "Некорректная сумма в окне оплаты");
        TestHelper.assertTextEquals("Оплата: Услуги связи Номер:375297777777", phoneElement.getText().trim(), "Некорректный номер телефона в окне оплаты");

        // Проверка наличия полей и иконок
        WebElement cardNumberField = webDriver.findElement(By.xpath("//app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/input"));
        WebElement cardHolderField = webDriver.findElement(By.xpath("//app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/input"));
        WebElement expirationField = webDriver.findElement(By.xpath("//app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/input"));
        WebElement cvcField = webDriver.findElement(By.xpath("//app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/input"));
        WebElement paymentSystemIcons = webDriver.findElement(By.xpath("//app-input/div/div/div[2]/div/div"));

        TestHelper.assertElementDisplayed(cardNumberField, "Поле ввода номера карты не отображается");
        TestHelper.assertElementDisplayed(cardHolderField, "Поле ввода имени владельца карты не отображается");
        TestHelper.assertElementDisplayed(expirationField, "Поле ввода срока действия карты не отображается");
        TestHelper.assertElementDisplayed(cvcField, "Поле ввода CVC не отображается");
        TestHelper.assertElementDisplayed(paymentSystemIcons, "Иконки платёжных систем не отображаются");

        // Переключение с iframe
        webDriver.switchTo().defaultContent();
    }
}
