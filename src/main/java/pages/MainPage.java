package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Constants.BASE_URI;

public class MainPage {
    WebDriver driver;
    String statusBuns;
    String statusSauce;
    String statusFillings;
    private By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private By bunSelectButton = By.xpath(".//span[text()='Булки']");
    private By bunParent = By.xpath(".//span[text()='Булки']/..");
    private By sauceSelectButton = By.xpath(".//span[text()='Соусы']");
    private By sauceParent = By.xpath(".//span[text()='Соусы']/..");
    private By fillingSelectButton = By.xpath(".//span[text()='Начинки']");
    private By fillingParent = By.xpath(".//span[text()='Начинки']/..");
    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver){
        this.driver=driver;
    }
    @Step("Открыть stellarburgers")
    public void open() {
        driver.get(BASE_URI);
    }
    @Step("Дождаться загрузки главной страницы")
    public void waitMainPage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
    }
    @Step("Проверить что отображается кнопка Оформить заказ")
    public boolean checkOrderButton() {
        return driver.findElement(orderButton).isDisplayed();
    }
    @Step("Нажать на кнопку личного кабинета в хэдере")
    public void clickPersonalAccount() {
        driver.findElement(personalAccountButton).click();
    }
    @Step("Нажать на кнопку Войти в аккаунт")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    @Step("Перейти в конструкторе в раздел Булки")
    public void clickBuns() {
        statusBuns = driver.findElement(bunParent).getAttribute("class");
        driver.findElement(bunSelectButton).click();
    }
    @Step("Проверить что таб теперь на Булки в конструкторе")
    public boolean checkBuns() {
        boolean newStatus = driver.findElement(bunParent).getAttribute("class").contains("tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
        return newStatus;
    }
    @Step("Перейти в конструкторе в раздел Соусы")
    public void clickSauce() {
        statusSauce = driver.findElement(sauceParent).getAttribute("class");
        driver.findElement(sauceSelectButton).click();
    }
    @Step("Проверить что таб теперь на Соусы в конструкторе")
    public boolean checkSauce() {
        boolean newStatus = driver.findElement(sauceParent).getAttribute("class").contains("tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
        return newStatus;
    }
    @Step("Перейти в конструкторе в раздел Начинки")
    public void clickFilling() {
        statusFillings = driver.findElement(fillingParent).getAttribute("class");
        driver.findElement(fillingSelectButton).click();
    }
    @Step("Проверить что отображается текст Начинки в конструкторе")
    public boolean checkFilling() {
        boolean newStatus = driver.findElement(fillingParent).getAttribute("class").contains("tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect");
        return newStatus;
    }
}
