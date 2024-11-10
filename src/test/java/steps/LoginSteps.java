package steps;

import components.HamburgerMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.opentest4j.AssertionFailedError;

import static pages.LoginPage.*;
import static pages.ShoesPage.*;

import java.util.List;

public class LoginSteps
{

    @Given("Navigate to Login Page")
    public void navigate_to_login_page() throws Throwable
    {
        HamburgerMenu.ToggleMenu();

        HamburgerMenu.ClickOption("Sign In Portal");
    }

    @When("Login Credentials Populated")
    public void login_credentials_populated()throws Throwable
    {
        login("test_user", "test_pass");
    }

    @When("Login Credentials Empty")
    public void login_credentials_empty()throws Throwable
    {
        login("", "");
    }

    @Then("Product Category Page Loads")
    public void product_category_page_loads()throws Throwable
    {
        List<WebElement> shoes = get_shoes();

        Assert.assertEquals(3, shoes.size());
    }

    @Then("Login Validation Error")
    public void login_validation_error()throws Throwable
    {
        Assert.assertEquals(
                "Both Username and Password field are required",
                login_validation()
        );
    }

    @Then("Fail Test")
    public void fail_test()throws Throwable
    {
        throw new AssertionFailedError();
    }
}
