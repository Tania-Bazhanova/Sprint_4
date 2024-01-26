package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentInfoOrderPage {

    private WebDriver driver;

    // локатор инпута Когда привезти самокат
    private By dateOfDeliveryScooter = By.cssSelector("[placeholder = '* Когда привезти самокат']");
    // локатор инпута Срок аренды
    private By periodOfRental = By.className("Dropdown-placeholder");
    // локатор выпадающего списка у Срока аренды

    // локатор инпута Цвет самоката - чёрный жемчуг
    private By colorScooterBlack = By.id("black");
    // локатор инпута Цвет самоката - серая безысходность
    private By colorScooterGray = By.id("grey");
    // локатор инпута Комментарий
    private By clientsComment = By.cssSelector("[placeholder = 'Комментарий для курьера']");
    // локатор кнопки Заказать на странице Про аренду
    private By buttonOrder = By.xpath(".//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Заказать']");
    // локатор кнопки Да на модалке Хотите оформить заказ
    private By buttonYes = By.xpath(".//*[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text() = 'Да']");

    public RentInfoOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // метод заполнения поля Когда привезти самокат
    public void enterDateOfDeliveryScooter(String date) {
        driver.findElement(dateOfDeliveryScooter).sendKeys(date);
        driver.findElement(By.xpath(String.format(".//*[contains(@class, 'react-datepicker__day') and (text() = '%s')]", date.split("\\.")[0]))).click();
    }

    // метод заполнения поля срок аренды
    public void clickDropdownRentTime(String amountDays) {
        driver.findElement(periodOfRental).click();
        driver.findElement(By.xpath(String.format(".//*[text() = '%s']", amountDays))).click();
    }

    // метод выбора скутера черного цвета
    public void clickCheckboxColorScooterBlack() {
        driver.findElement(colorScooterBlack).click();
    }

    // метод выбора скутера серого цвета
    public void clickCheckboxColorScooterGray() {
        driver.findElement(colorScooterGray).click();
    }

    // метод заполнения поля Комментарий
    public void enterDateOfClientsComment(String comment) {
        driver.findElement(clientsComment).sendKeys(comment);
    }

    // метод нажатия на кнопку Заказать
    public void clickButtonYes() {
        driver.findElement(buttonYes).click();
    }

    // метод нажатия на кнопку да в модалке Хотите оформить заказ
    public void clickButtonOrder() {
        driver.findElement(buttonOrder).click();
    }

    // метод заполнения данных на странице Про аренду - цвет скутера черный
    public void enterRentInfoOnOrderPageColorBlack(String date, String amountDays, String comment) {
        enterDateOfDeliveryScooter(date);
        clickDropdownRentTime(amountDays);
        clickCheckboxColorScooterBlack();
        enterDateOfClientsComment(comment);
        clickButtonOrder();
        clickButtonYes();
    }

    // метод заполнения данных на странице Про аренду - цвет скутера серый
    public void enterRentInfoOnOrderPageColorGrey(String date, String amountDays, String comment) {
        enterDateOfDeliveryScooter(date);
        clickDropdownRentTime(amountDays);
        clickCheckboxColorScooterGray();
        enterDateOfClientsComment(comment);
        clickButtonOrder();
        clickButtonYes();
    }
}
