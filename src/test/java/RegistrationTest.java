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
import pages.LoginPage;
import pages.RegistrationPage;
import utils.Constants;

import static utils.DataGenerator.*;
import static org.junit.Assert.assertTrue;
public class RegistrationTest {
    private WebDriver driver;
    private User user;

    @Before
    public void setUp() {
        String browserName = System.getProperty("chrome"); // Прописать "chrome" для запуска с хрома, "yandex" для запуска с яндекса
        driver = WebDriverFactory.get(browserName);
    }
    @Test
    @DisplayName("Регистрация пользователя")
    @Description("Проверка успешной регистрации пользователя")
    public void registrationUser(){
        user = randomUser();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.inputName(user);
        registrationPage.inputEmailRegistration(user);
        registrationPage.inputPasswordRegistration(user);
        registrationPage.clickRegistrationButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitLoginPage();
        assertTrue(loginPage.checkLoginText());
    }
    @Test
    @DisplayName("Ошибка при регистрации")
    @Description("Проверка отображения ошибки при регистрации с некорректным паролем(менее 6 символов)")
    public void registrationWrongPassUser(){
        user = randomWrongUser();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.inputName(user);
        registrationPage.inputEmailRegistration(user);
        registrationPage.inputPasswordRegistration(user);
        registrationPage.clickRegistrationButton();
        assertTrue(registrationPage.checkWrongPasswordMessage());
    }
    @After
    public void tearDown() {
        RestAssured.baseURI= Constants.BASE_URI;
        UserClient userClient = new UserClient();
        userClient.deleteUser();
        driver.quit();
    }
}
