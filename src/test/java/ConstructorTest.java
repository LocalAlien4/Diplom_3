import driver.WebDriverFactory;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest {
    private WebDriver driver;
    @Before
    public void setUp() {
        String browserName = System.getProperty("chrome"); // Прописать "chrome" для запуска с хрома, "yandex" для запуска с яндекса
        driver = WebDriverFactory.get(browserName);
    }
    @Test
    @DisplayName("Переход к разделу Булки")
    @Description("Проверка перехода к разделу Булки в конструкторе")
    public void checkRedirectToBuns(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFilling();
        mainPage.clickBuns();
        assertTrue(mainPage.checkBuns());
    }
    @Test
    @DisplayName("Переход к разделу Соусы")
    @Description("Проверка перехода к разделу Соусы в конструкторе")
    public void checkRedirectToSauce(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFilling();
        mainPage.clickSauce();
        assertTrue(mainPage.checkSauce());
    }
    @Test
    @DisplayName("Переход к разделу Начинки")
    @Description("Проверка перехода к разделу Начинки в конструкторе")
    public void checkRedirectToFilling(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFilling();
        assertTrue(mainPage.checkFilling());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
