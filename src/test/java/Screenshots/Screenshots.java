package Screenshots;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Screenshots {

    static WebDriver driver;

    public static void capture(WebDriver driver, String path, String fileName) {
        try {
            new File(path).mkdirs();
            try ( FileOutputStream out = new FileOutputStream(path + File.separator + "screenshot-" + fileName + ".png")) {
                out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            }
        } catch (IOException | WebDriverException e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }
}