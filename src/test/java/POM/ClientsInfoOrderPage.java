package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientsInfoOrderPage {

    private WebDriver driver;

    // локатор инпута Имя
    private By clientName = By.cssSelector("[placeholder = '* Имя']");
    // локатор инпута Фамилия
    private By clienSurname = By.cssSelector("[placeholder = '* Фамилия']");
    // локатор инпута Адрес доставки
    private By deliveryAddress = By.cssSelector("[placeholder = '* Адрес: куда привезти заказ']");
    //локатор инпута Станция метро
    private By metroStation = By.className("select-search__input");
    // локатор инпута Телефон
    private By phoneNumber = By.cssSelector("[placeholder = '* Телефон: на него позвонит курьер']");
    // локатор кнопки Далее
    private By buttonFurther = By.cssSelector("[class= 'Button_Button__ra12g Button_Middle__1CSJM']");

    public ClientsInfoOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод заполнения поля Имя
    public void enterDataInClientName(String name) {
        driver.findElement(clientName).sendKeys(name);
    }

    // метод заполнения поля Фамилия
    public void enterDataInClienSurname(String surName) {
        driver.findElement(clienSurname).sendKeys(surName);
    }

    // метод заполнения поля Адрес доставки
    public void enterDataInDeliveryAddress(String clientDeliveryAddress) {
        driver.findElement(deliveryAddress).sendKeys(clientDeliveryAddress);
    }

    // метод заполнения поля Станция метро
    public void selectMetroStation(String station) {
        driver.findElement(metroStation).click();
        driver.findElement(By.xpath(String.format(".//*[text() = '%s']", station))).click();
    }

    // метод заполнения поля Телефон
    public void enterDataInPhoneNumber(String clientPhoneNumber) {
        driver.findElement(phoneNumber).sendKeys(clientPhoneNumber);
    }

    // метод нажатия на кнопку Далее
    public void clickButtonFurther() {
        driver.findElement(buttonFurther).click();
    }

    // метод заполнения данных на странице Для кого самокат
    public void enterClientsInfoOnOrderPage(String name, String surName, String clientDeliveryAddress, String station, String clientPhoneNumber) {
        enterDataInClientName(name);
        enterDataInClienSurname(surName);
        enterDataInDeliveryAddress(clientDeliveryAddress);
        selectMetroStation(station);
        enterDataInPhoneNumber(clientPhoneNumber);
        clickButtonFurther();
    }
}

