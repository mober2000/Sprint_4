import pageobject.HomePageScooter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckTextDropDownList {
    private WebDriver driver;

    @Before
    public void BeforeTest() {
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
    public void сheckTextDropDownList() {
        String[] dropDownList = new String[]{
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", "Да, обязательно. Всем самокатов! И Москве, и Московской области."};
        HomePageScooter homePageScooter = new HomePageScooter(driver);
        homePageScooter.clickCookeButton();
        homePageScooter.scrollDropdownList();

        for (int i = 0; i < 8; i++) {
            homePageScooter.clickAccordionButton(i);
            homePageScooter.checkForTextAccordionPanel(dropDownList[i], i);
        }
    }
}
