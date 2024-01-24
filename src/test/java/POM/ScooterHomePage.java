package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ScooterHomePage {

    private WebDriver driver;
    // локатор кнопки Заказать в хедере
    private By headerOrderButton = By.className("Button_Button__ra12g");
    // локатор кнопки Заказать на странице
    private By pageOrderButton = By.xpath(".//button[contains( @class,'Button_Button__ra12g Button_')]");

    // локатор кнопки Да все привыкли
    private By buttonCloseCookie = By.id("rcc-confirm-button");

    // локатор элементов accordion
    private By accordionItem = By.className("accordion__item");

    // локатор раскрывающихся элементов accordion
    private By accordionPanel = By.xpath(".//div[@class = 'accordion__panel']");

    public ScooterHomePage(WebDriver driver) {

        this.driver = driver;
    }

    public By getPageOrderButton() {

        return pageOrderButton;
    }

    // метод нажатия на кнопку Заказать в хедере
    public void clickheaderOrderButton() {

        driver.findElement(headerOrderButton).click();
    }

    // метод нажатия на кнопку Заказать на домашней странице
    public void clickPageOrderButton() {
        driver.findElement(pageOrderButton).click();
    }

    // метод нажатия на кнопку Да все привыкли чтобы закрыть окно с куками
    public void clickButtonCloseCookie() {
        driver.findElement(buttonCloseCookie).click();
    }

    // метод нажатия на i-ый элемент Вопросов о важном
    public void clickAccordionItem(int item) {
        List<WebElement> elements = driver.findElements(accordionItem);
        elements.get(item).click();
    }

    // метод получения текста из раскрывающегося accordion
    public String getTextOfAccordionPanel(int item) {
        return driver.findElements(accordionPanel).get(item).getText();
    }
}
