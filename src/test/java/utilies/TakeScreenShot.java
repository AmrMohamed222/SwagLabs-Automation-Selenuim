package utilies;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class TakeScreenShot {

    public static File takesScreenshot(WebDriver driver) {

        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        } catch (Exception e) {
            e.printStackTrace();

        }  return null;
    }
}
