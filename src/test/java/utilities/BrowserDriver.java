package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BrowserDriver {

    public static WebDriverWait wait;
    public static WebDriver driver;
    private static ChromeOptions options;

    public BrowserDriver()
    {
        SetOptions();

        SetDriver();

        SetWait(30);
    }

    private void SetOptions()
    {
        options = new ChromeOptions();
        options.addArguments(
                "--remote-allow-origins=*",
                "--disable-browser-side-navigation",
                "enable-automation",
                "--disable-gpu",
                "--disable-extensions",
                "--start-maximized",
                "--enable-javascript");
    }

    private void SetDriver()
    {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
    }

    private void SetWait(int timeout)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public void Quit()
    {
        driver.quit();
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
