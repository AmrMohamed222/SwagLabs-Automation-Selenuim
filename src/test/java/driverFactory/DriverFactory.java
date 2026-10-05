package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Locale;

public class DriverFactory {
    public static WebDriver getWebDriver(String browser) {

        WebDriver driver;
        switch (browser.toLowerCase().trim()) {
            case "chrome":
                driver = GetChromeDriver.getChromeDriver();
                break;
            case "edge":
                driver = GetEdgeDriver.getEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
        return driver;
    }

    public static void quitWebDriver(String browser) {

        switch (browser.toLowerCase().trim()) {
            case "chrome":
                GetChromeDriver.quitDriver();
                break;
            case "edge":
                GetEdgeDriver.quitDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }
}
