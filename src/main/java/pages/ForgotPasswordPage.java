package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Constants.FORGOT_PASSWORD_URI;

public class ForgotPasswordPage {
    WebDriver driver;
    private By loginPageRecoveryButton = By.xpath(".//a[text()='Войти']");
    public ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
    }
    @Step("Перейти на страницу восстановления пароля")
    public void open() {
        driver.get(FORGOT_PASSWORD_URI);
    }
    @Step("Нажать на кнопку Войти")
    public void clickLoginButton() {
        driver.findElement(loginPageRecoveryButton).click();
    }
}
