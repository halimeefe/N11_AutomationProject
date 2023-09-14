package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    DialogContent c=new DialogContent();

    WebDriverWait wait=new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(20));

    @When("Verify you are on N11 Home Page")
    public void verify_you_are_on_n11_home_page() {

    }

    @And("Click Login")
    public void click_login() {
        c.clickFunc(c.login);
       // c.clickFunc(c.inputUsername);
        c.sendKeysFunc(c.inputUsername, c.findFromExcel("UserName"));
        c.sendKeysFunc(c.inputPassword,c.findFromExcel("Password"));
        c.clickFunction(c.loginButton);



    }

    @And("Verify successfully loged")
    public void verify_successfully_loged() {

        String expectedUrl="https://www.n11.com/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl=PageDriver.getDriver().getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl,"URL doğrulama başarısız oldu");


    }



}
