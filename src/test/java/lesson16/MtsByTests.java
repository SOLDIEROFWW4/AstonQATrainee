package lesson16;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.astondev.lesson16.utils.FormValidator;
import ru.astondev.lesson16.pages.HomePage;
import ru.astondev.lesson16.pages.PaymentPage;
import ru.astondev.lesson16.utils.TestHelper;

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
        TestHelper.handleCookiePopup(webDriver);
    }

    @AfterEach
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    @Owner("Maksakau M.")
    // Тест для проверки всех элементов выпадающего списка
    @Test
    @Epic(value = "mts.by")
    @Feature(value = "Проверка формы «Онлайн пополнение без комиссии»")
    @Story(value = "Проверка выпадающего списка формы")
    @Description(value = "Тест для проверки всех элементов выпадающего списка")
    public void testPaymentServicesDropdownOptions() {
        HomePage homePage = new HomePage(webDriver);
        List<String> options = homePage.openDropdownAndGetOptions();

        FormValidator formValidator = new FormValidator(webDriver);

        for (String optionText : options) {
            homePage.selectOption(optionText);
            formValidator.validateFormFields(optionText);
            homePage.openDropdown();
        }
    }


    @Owner("Maksakau M.")
    // Тест для заполнения полей формы оплаты услуг реквизитами и переход на iframe с проверкой его полей.
    @Test
    @Epic(value = "mts.by")
    @Feature(value = "Проверка формы «Онлайн пополнение без комиссии»")
    @Story(value = "Проверка заполнения input полей и проверка элементов iframe")
    @Description(value = "Тест для заполнения полей формы оплаты услуг реквизитами и переход на iframe с проверкой его полей")
    public void testPaymentSection() {
        PaymentPage paymentPage = new PaymentPage(webDriver);
        paymentPage.fillPaymentForm("297777777", "5", "example@gmail.com");
        paymentPage.switchToPaymentFrameAndValidate();
    }
}
