package utilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks
{
    public static BrowserDriver driver;

    @Before
    public void setUp(Scenario scenario)
    {
        driver = new BrowserDriver();
    }

    @After
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed()) {
            final byte[] screenshot = driver.takeScreenshot();
            scenario.attach(screenshot, "image/png", scenario.getName() + " SCREENSHOT");
        }
        driver.Quit();
    }
}
