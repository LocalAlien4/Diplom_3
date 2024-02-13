package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    public static WebDriver get(String browserName)  throws RuntimeException{
        switch (System.getProperty("browser", "chrome")) {
            case "chrome":
                ChromeDriver chromeDriver = new ChromeDriver();
                chromeDriver.manage().window().maximize();
                return chromeDriver;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                ChromeDriver yandexDriver = new ChromeDriver();
                yandexDriver.manage().window().maximize();
                return yandexDriver;
            default:
                throw new RuntimeException("Ошибка выбора браузера");
        }
    }
}
