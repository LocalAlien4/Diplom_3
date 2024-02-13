package pages;

import api.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.Constants.LOGIN_PAGE_URI;

public class LoginPage {
    WebDriver driver;
 //   private By registrationButton = By.xpath(".//a[text()='Зарегистрироваться']");
    private By emailField = By.xpath(".//label[text()='Email']//following-sibling::input");
    private By passwordField = By.xpath(".//label[text()='Пароль']//following-sibling::input");
    private By loginButton = By.xpath(".//button[text()='Войти']");
    private By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private By loginText = By.xpath(".//h2[text()='Вход']");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    @Step("Перейти на страницу авторизации")
    public void open() {
        driver.get(LOGIN_PAGE_URI);
    }
    @Step("Дождаться загрузки страницы")
    public void waitLoginPage(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }
    @Step("Проверить, что нахожусь на странице авторизации")
    public boolean checkLoginText() {
        return driver.findElement(loginText).isDisplayed();
    }
//    @Step("Нажать на кнопку зарегистрироваться")
//    public void clickRegistration() {
//        driver.findElement(registrationButton).click();
//    }
    @Step("Заполнить поле email")
    public void inputEmail(User user) {
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(user.getEmail());
    }
    @Step("Заполнить поле пароль")
    public void inputPassword(User user) {
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(user.getPassword());
    }
    @Step("Нажать на кнопку Войти")
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    @Step("Нажать на кнопку Восстановить пароль")
    public void clickForgotPassword() {
        driver.findElement(forgotPasswordButton).click();
    }
}
