package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class OrderPageScooter {
    private WebDriver driver;
    //Локаторы  данных о клиенте
    private By orderFirstName = By.xpath(".//input[@placeholder='* Имя']");
    private By orderSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    private By orderAddressPoint = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By orderMetroStationField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By orderContactPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By orderNextButton = By.xpath(".//button[text()='Далее']");
    //Локаторы данных об аренде
    private By orderWhen = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By orderWhenCalendar = By.xpath(".//div[@aria-label='Choose четверг, 10-е ноября 2022 г.']");
    private By orderHowLong = By.className("Dropdown-placeholder");
    private By orderHowLongTwoDays = By.xpath(".//div[text()='двое суток']");
    private By orderColorBlack = By.xpath(".//label[@for='black']");
    private By orderCommentCour = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButtonDone = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Заказать')]");
    //Подтверждение заказа
    private By orderYesButton = By.xpath("//*[@class='Button_Button__ra12g Button_Middle__1CSJM' and contains(text(), 'Да')]");
    private By orderDoneHeader = By.xpath("//div[@class='Order_ModalHeader__3FDaJ and text()='Заказ оформлен']");

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод имени
    public void sendFirstName(String name) {
        driver.findElement(orderFirstName).sendKeys(name);
    }

    //Ввод фамилии
    public void sendSecondName(String secondName) {
        driver.findElement(orderSecondName).sendKeys(secondName);
    }

    //Ввод адреса
    public void sendDeliveryAddress(String address) {
        driver.findElement(orderAddressPoint).sendKeys(address);
    }

    //Выбор поля для ввода станции и выбора
    public void sendMetroStationField(String metro) {
        driver.findElement(orderMetroStationField).sendKeys(metro);
        String metroName = driver.findElement(By.xpath("//div[@class='Order_Text__2broi' and text()='" + metro + "']")).getText();
        assertEquals(metroName, metro);
        driver.findElement(By.xpath("//div[@class='Order_Text__2broi' and text()='" + metro + "']")).click();
    }

    //Ввод телефона
    public void sendNumberPhone(String number) {
        driver.findElement(orderContactPhone).sendKeys(number);
    }

    //Клик по кнопке далее
    public void clickNextWindow() {
        driver.findElement(orderNextButton).click();
    }

    //Клик на выбор даты
    public void clickDateButton() {
        driver.findElement(orderWhen).click();
    }

    //Клик на конкретную дату
    public void clickSendDate() {
        driver.findElement(orderWhenCalendar).click();
    }

    //Клик на выпадающий список выбора времени аренды
    public void orderHowLong() {
        driver.findElement(orderHowLong).click();
    }

    //Клик на выбор времени аренды
    public void clickChangeTimeLeasing() {
        driver.findElement(orderHowLongTwoDays).click();
    }

    //Выбор чекбокса с цветом
    public void clickOrderColorBlack() {
        driver.findElement(orderColorBlack).click();
    }

    //Комментарий
    public void sendComment(String comment) {
        driver.findElement(orderCommentCour).sendKeys(comment);
    }

    //Клик по кнопкам и отображение окна об успешном отображении заказа
    public void clickOrderButtonDone() {
        driver.findElement(orderButtonDone).click();
        driver.findElement(orderYesButton).click();
        driver.findElement(orderDoneHeader).isDisplayed();
    }

    //Методы окна ввода данных пользователя в одном шаге
    public void sendUserData(String name, String secondName, String address, String station, String number) {
        sendFirstName(name);
        sendSecondName(secondName);
        sendDeliveryAddress(address);
        sendMetroStationField(station);
        sendNumberPhone(number);
        clickNextWindow();
    }

    //Метод ввода данных о доставке в один шаг
    public void sendDeliveryDataAndDoneOrder(String comment) {
        clickDateButton();
        clickSendDate();
        orderHowLong();
        clickChangeTimeLeasing();
        clickOrderColorBlack();
        sendComment(comment);
        clickOrderButtonDone();
    }
}

