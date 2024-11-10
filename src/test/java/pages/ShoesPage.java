package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BrowserDriver;

import java.util.List;

public class ShoesPage extends BrowserDriver
{
    public static String shoes_thumbnails_xpath = "//img[@id='Shoethumbnail']";

    public static List<WebElement> get_shoes()
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(shoes_thumbnails_xpath)));

        return driver.findElements(By.xpath(shoes_thumbnails_xpath));
    }
}
