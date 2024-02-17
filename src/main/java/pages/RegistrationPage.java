package pages;

import api.User;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Constants.REGISTER_PAGE_URI;

public class RegistrationPage {
    WebDriver driver;
    private By nameRegistrationInput = By.xpath(".//label[text()='Имя']//following-sibling::input");
    private By emailRegistrationInput = By.xpath(".//label[text()='Email']//following-sibling::input");
    private By passwordRegistrationInput = By.xpath(".//label[text()='Пароль']//following-sibling::input");
    private By registrationButtonRegistration = By.xpath(".//Button[text()='Зарегистрироваться']");
    private By wrongPasswordMessage = By.xpath(".//p[text()='Некорректный пароль']");
    private By loginPageButton = By.xpath(".//a[text()='Войти']");
    public RegistrationPage(WebDriver driver){
        this.driver=driver;
    }
    @Step("Перейти на страницу регистрации")
    public void open() {
        driver.get(REGISTER_PAGE_URI);
    }
    @Step("Заполнить поле Имя")
    public void inputName(User user) {
        driver.findElement(nameRegistrationInput).click();
        driver.findElement(nameRegistrationInput).sendKeys(user.getName());
    }
    @Step("Заполнить поле Email")
    public void inputEmailRegistration(User user) {
        driver.findElement(emailRegistrationInput).click();
        driver.findElement(emailRegistrationInput).sendKeys(user.getEmail());
    }
    @Step("Заполнить поле Пароль")
    public void inputPasswordRegistration(User user) {
        driver.findElement(passwordRegistrationInput).click();
        driver.findElement(passwordRegistrationInput).sendKeys(user.getPassword());
    }
    @Step("Нажать на кнопку зарегистрироваться")
    public void clickRegistrationButton() {
        driver.findElement(registrationButtonRegistration).click();
    }
    @Step("Проверить сообщение об ошибке Некорректный пароль")
    public boolean checkWrongPasswordMessage() {
        return driver.findElement(wrongPasswordMessage).isDisplayed();
    }
    @Step("Нажать на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginPageButton).click();
    }
}
