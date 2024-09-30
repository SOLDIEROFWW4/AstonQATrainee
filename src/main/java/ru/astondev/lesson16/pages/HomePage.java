package ru.astondev.lesson16.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public List<String> openDropdownAndGetOptions() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement dropdownButton = webDriver.findElement(By.xpath("//button[@class='select__header']"));
        dropdownButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='pay-section']//ul")));

        List<WebElement> optionsElements = webDriver.findElements(By.xpath("//li[@class='select__item']/p[@class='select__option']"));
        List<String> options = new ArrayList<>();

        for (WebElement option : optionsElements) {
            options.add(option.getText());
        }

        System.out.println("Количество опций: " + options.size());
        for (String option : options) {
            System.out.println("Опция: " + option);
        }

        return options;
    }

    public void selectOption(String optionText) {
        List<WebElement> options = webDriver.findElements(By.xpath("//li[@class='select__item']/p[@class='select__option']"));
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                try {
                    option.click();
                } catch (ElementClickInterceptedException e) {
                    ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", option);
                }
            }
        }
    }

    public void openDropdown() {
        WebElement dropdownButton = webDriver.findElement(By.xpath("//button[@class='select__header']"));
        dropdownButton.click();
    }
}
