package components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utilities.BrowserDriver.wait;

public class HamburgerMenu
{
    private static final String element_xpath = "//nav[@role='navigation']";
    private static final String menu_toggle_xpath = "//input[@type='checkbox']";
    private static final String nav_content_xpath = "//ul[@id='menu']";

    public static void ToggleMenu()
    {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(String.format("%s%s",
                        element_xpath,
                        menu_toggle_xpath))))
                .click();
    }

    public static void ClickOption(String text)
    {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("%s%s//li[contains(text(), '%s')]",
                        element_xpath,
                        nav_content_xpath,
                        text))))
                .click();
    }
}
