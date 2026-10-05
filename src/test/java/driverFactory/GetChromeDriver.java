package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetChromeDriver {

    public static WebDriver driver = null;

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--incognito");
            driver = new ChromeDriver(chromeOptions);
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
