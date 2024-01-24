package ru.yandex.praktikum;

import POM.ClientsInfoOrderPage;
import POM.RentInfoOrderPage;
import POM.ScooterHomePage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestOrderCreation {

    private WebDriver driver;
    private String expected = "Заказ оформлен";

    // 1 Тест создания заказа черного скутера через кнопку Заказать в хедере
    @Test
    public void orderCreationClickHeaderOrderButton() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        ScooterHomePage object = new ScooterHomePage(driver);
        ClientsInfoOrderPage client = new ClientsInfoOrderPage(driver);
        RentInfoOrderPage rent = new RentInfoOrderPage(driver);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        // вызов метода нажатия кнопки в хедере
        object.clickheaderOrderButton();

        //вызов метода заполнения полей на странице Для кого самокат
        client.enterClientsInfoOnOrderPage("Татьяна", "Бажанова", "40 лет октября, д 15, кв.3", "Чистые пруды", "79524657043");

        //вызов метода заполнения полей на странице Про аренду
        rent.enterRentInfoOnOrderPageColorBlack("25.01.2024", "четверо суток", "просто коммент для тестирования");

        // Ожидание появления модального окна с текстом Заказ оформлен
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3")));

        // Получаем текст с открывшейся модалки
        String result = driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")).getText();

        Assert.assertEquals("Заказ не создан", true, result.contains(expected));

        driver.quit();
    }


    // 2 Тест создания заказа серого скутера через кнопку Заказать на домашней странице
    @Test
    public void orderCreationClickPageOrderButton() {
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();

        ScooterHomePage object = new ScooterHomePage(driver);
        ClientsInfoOrderPage client = new ClientsInfoOrderPage(driver);
        RentInfoOrderPage rent = new RentInfoOrderPage(driver);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Вызов метода на закрытие окна с информацией о куках
        object.clickButtonCloseCookie();

        // Ожидание появления кнопки Заказать на странице
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(object.getPageOrderButton()));

        // вызов метода нажатия кнопки на домашней странице
        object.clickPageOrderButton();


        //вызов метода заполнения полей на странице Для кого самокат
        client.enterClientsInfoOnOrderPage("Ольга", "Терентьева", "проспект Гагарина, д 196, кв.15", "Нижегородская", "79524899657");

        //вызов метода заполнения полей на странице Про аренду
        rent.enterRentInfoOnOrderPageColorGrey("29.01.2024", "двое суток", "какой-то комментарий");

        // Ожидание появления модального окна с текстом Заказ оформлен
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Modal__YZ-d3")));

        // Получаем текст с открывшейся модалки
        String result = driver.findElement(By.xpath(".//div[@class = 'Order_ModalHeader__3FDaJ' and text() = 'Заказ оформлен']")).getText();

        Assert.assertEquals("Заказ не создан", true, result.contains(expected));

        driver.quit();
    }
}
