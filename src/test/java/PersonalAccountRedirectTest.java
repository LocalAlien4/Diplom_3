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
import pages.MainPage;
import pages.PersonalAccountPage;
import utils.Constants;

import static org.junit.Assert.assertTrue;
import static utils.DataGenerator.randomUser;

public class PersonalAccountRedirectTest {
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

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.waitLoginPage();
        loginPage.inputEmail(user);
        loginPage.inputPassword(user);
        loginPage.clickLogin();
    }
    @Test
    @DisplayName("Переход в личный кабинет")
    @Description("Проверка перехода по клику на Личный кабинет")
    public void checkRedirectToPersonalAccount(){
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.waitMainPage();
        mainPage.clickPersonalAccount();

        personalAccountPage.waitAccountPage();
        assertTrue(personalAccountPage.checkAccountButton());
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на Конструктор")
    public void checkRedirectFromPersonalAccountToConstructor(){
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.waitMainPage();
        mainPage.clickPersonalAccount();

        personalAccountPage.waitAccountPage();
        personalAccountPage.clickConstructor();
        assertTrue(mainPage.checkOrderButton());
    }
    @Test
    @DisplayName("Переход из личного кабинета в конструктор через логотип")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на логотип")
    public void checkRedirectFromPersonalAccountToLogotip(){
        MainPage mainPage = new MainPage(driver);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        mainPage.waitMainPage();
        mainPage.clickPersonalAccount();

        personalAccountPage.waitAccountPage();
        personalAccountPage.clickLogotip();
        assertTrue(mainPage.checkOrderButton());
    }
    @After
    public void tearDown() {
        userClient.deleteUser();
        driver.quit();
    }
}
