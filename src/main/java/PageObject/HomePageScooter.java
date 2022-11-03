package PageObject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class HomePageScooter {

    private WebDriver driver;

    //Кнопки на главной странице
    private By orderTitle = By.className("Button_Button__ra12g");
    private By orderMiddlePage = By.className("Button_Middle__1CSJM");
    private By orderStatus = By.className("Header_Link__1TAG7");
    private By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    private By yandexLogo = By.className("Header_LogoYandex__3TSOI");
    private By yandexDzenPageLogo = By.className("arrow__button");
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    //локаторы кнопок выпадающего списка
    private String[] accordionButtonArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    };

    //локаторы текста выпадающего списка
    private String[] accordionPanelArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"
    };

    public HomePageScooter(WebDriver driver){
        this.driver = driver;
    }

    //Метод клика по кнопке заказа в заголовке
    public void clickFirstOrderButtonTitle(){
        driver.findElement(orderTitle).click();
    }

    //Метод клика по кнопке заказа на середине страницы
    public void clickSecondOrderButtonMiddlePage(){
        driver.findElement(orderMiddlePage).click();
    }

    //Метод клика по кнопке уведомления о куки
    public void clickCookeButton(){
        driver.findElement(cookieButton).click();
    }

    //Метод клика по кнопке выпадающего списка
    public void clickAccordionButton(int numberButton){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id(accordionButtonArray[numberButton])));

        driver.findElement(By.id(accordionButtonArray[numberButton])).click();
    }

    //Метод на соответствие текста в выпадающем списке
    public void checkForTextAccordionPanel(String accordionText, int numberPanel){
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(accordionPanelArray[numberPanel])));

        String textPanelDropDown = driver.findElement(By.id(accordionPanelArray[numberPanel])).getText();
        assertEquals(accordionText, textPanelDropDown);
    }

    //Метод прокрутки главной страницы в самый низ
    public void scrollDropdownList(){

        WebElement element = driver.findElement(By.id(accordionButtonArray[7]));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //Метод скролит до кнопки заказать посередине страницы
    public void scrollOrderButton(){

        WebElement element = driver.findElement(orderMiddlePage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }









}
