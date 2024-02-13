package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class PersonalAccountPage {
    WebDriver driver;
    private By constructorButton = By.xpath(".//p[text()='Конструктор']");
    private By logotipButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    private By logoutButton = By.xpath(".//button[text()='Выход']");
    private By accountButton = By.xpath(".//a[text()='Профиль']");
    public PersonalAccountPage(WebDriver driver){
        this.driver=driver;
    }
//    @Step("Перейти на страницу личного кабинета")
//    public void open() {
//        driver.get(PROFILE_URI);
//    }
    @Step("Дождаться загрузки профиля")
    public void waitAccountPage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }
    @Step("Проверить что отображается кнопка Профиль")
    public boolean checkAccountButton() {
        return driver.findElement(accountButton).isDisplayed();
    }
    @Step("Перейти на Конструктор в хэдере")
    public void clickConstructor() {
        driver.findElement(constructorButton).click();
    }
    @Step("Перейти в конструктор через логотип в хэдере")
    public void clickLogotip() {
        driver.findElement(logotipButton).click();
    }
    @Step("Выход из личного кабинета")
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

}
