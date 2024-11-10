package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.BrowserDriver;

public class LoginPage extends BrowserDriver
{
    public static String login_username_xpath = "//input[@id='usr']";
    public static String login_password_xpath = "//input[@id='pwd']";
    public static String login_button_xpath = "//input[@type='submit']";
    public static String login_validation_xpath = "//span[@class='error']";

    public static void login(String user, String pass)
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login_username_xpath))).sendKeys(user);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(login_password_xpath))).sendKeys(pass);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath((login_button_xpath)))).click();
    }

    public static String login_validation()
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(login_validation_xpath))).getText();
    }
}
