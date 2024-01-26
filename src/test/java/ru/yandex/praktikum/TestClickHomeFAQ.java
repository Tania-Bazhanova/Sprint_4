package ru.yandex.praktikum;

import POM.ScooterHomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class TestClickHomeFAQ {

    private WebDriver driver;
    private String expected;
    private int item;


    public TestClickHomeFAQ(String expected, int item) {
        this.expected = expected;
        this.item = item;
    }

    @Parameterized.Parameters
    public static Object[][] getAccordionComponent() {
        return new Object[][]{
                {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", 1},
                {"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", 2},
                {"Только начиная с завтрашнего дня. Но скоро станем расторопнее.", 3},
                {"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", 5},
                {"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7}
        };
    }

    @Test
    public void checkClickFAQ() {
        driver = new ChromeDriver();
        ScooterHomePage object = new ScooterHomePage(driver);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        // закрытие окна с куками
        object.clickButtonCloseCookie();

        // нажатие на элемент Accordion
        object.clickAccordionItem(item);

        String actual = object.getTextOfAccordionPanel(item);

        Assert.assertEquals("Текст не совпадает с заданным", expected, actual);
    }

    @After
    public void terdown() {
        driver.quit();
    }
}