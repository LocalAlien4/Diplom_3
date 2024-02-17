import api.User;
import api.UserClient;
import driver.WebDriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;
import utils.Constants;

import static org.junit.Assert.assertTrue;

import static utils.DataGenerator.randomUser;

public class AuthorizationTest {

    private WebDriver driver;
    private User user;
    private UserClient userClient;
    @Before
    public void setUp() {
        String browserName = System.getProperty("chrome"); // Прописать "chrome" для запуска с хрома, "yandex" для запуска с яндекса
        driver = WebDriverFactory.get(browserName);
        RestAssured.baseURI= Constants.BASE_URI;
        user = randomUser();
        userClient = new UserClient();
        userClient.createUser(user).then();
    }
    @Test
    @DisplayName("Авторизация пользователя по кнопке в конструкторе")
    @Description("Проверка успешной авторизации пользователя по кнопке в конструкторе")
    public void authorizationConstructorUser(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickLogin();

        loginPage.waitLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(user);
        loginPage.clickLogin();
        mainPage.waitMainPage();
        assertTrue(mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Авторизация пользователя по кнопке в хэдере")
    @Description("Проверка успешной авторизации пользователя по кнопке в хэдере")
    public void authorizationHeaderUser(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickPersonalAccount();

        loginPage.waitLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(user);
        loginPage.clickLogin();
        mainPage.waitMainPage();
        assertTrue(mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку в форме регистрации")
    @Description("Проверка успешной авторизации пользователя через кнопку в форме регистрации")
    public void authorizationRegistrationUser(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.clickLoginButton();

        loginPage.waitLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(user);
        loginPage.clickLogin();
        mainPage.waitMainPage();
        assertTrue(mainPage.checkOrderButton());
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку в форме восстановления пароля")
    @Description("Проверка успешной авторизации пользователя через кнопку в форме восстановления пароля")
    public void authorizationForgotPasswordUser(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickLoginButton();

        loginPage.waitLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(user);
        loginPage.clickLogin();
        mainPage.waitMainPage();
        assertTrue(mainPage.checkOrderButton());
    }
    @After
    public void tearDown() {
        userClient.deleteUser();
        driver.quit();
    }

}
