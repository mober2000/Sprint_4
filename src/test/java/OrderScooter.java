import pageobject.HomePageScooter;
import pageobject.OrderPageScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrderScooter {
    private WebDriver driver;

    @Before
    public void beforeTest() {
        // создали драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        // перешли на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }

    @Test
    public void orderScooterFirstOrderButton() {

        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickCookeButton();
        homePageScooter.clickFirstOrderButtonTitle();
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.sendUserData(
                "Алексей", "Чебанов", "Москва", "Новокосино", "+79197795816");
        orderPageScooter.sendDeliveryDataAndDoneOrder("Просьба везти аккуратно");
    }


    //Отредачить
    @Test
    public void orderScooterSecondOrderButton() {
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickCookeButton();
        homePageScooter.scrollOrderButton();
        homePageScooter.clickSecondOrderButtonMiddlePage();
        OrderPageScooter orderPageScooter = new OrderPageScooter(driver);
        orderPageScooter.sendUserData(
                "Алексей", "Чебанов", "Москва", "Черкизовская", "+79197795816");
        orderPageScooter.sendDeliveryDataAndDoneOrder("Просьба везти аккуратно");
    }
}