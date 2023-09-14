package StepDefinitions;

import Pages.DialogContent;
import Utilities.PageDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class CheckProductPrice_Steps {

    DialogContent c=new DialogContent();
    WebDriverWait wait =new WebDriverWait(PageDriver.getDriver(), Duration.ofSeconds(30));

    @Given("Navigate to Website")
    public void navigateToWebsite() {
        PageDriver.getDriver().get("https://www.n11.com/");
        PageDriver.getDriver().manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='dn-slide-deny-btn']")));
        c.clickFunc(c.later);


    }

    @And("The User clicks on the Book,Music,Film,Game category")
    public void theUserClicksOnTheBookMusicFilmGameCategory() {
        c.clickFunc(c.bookMusicFilmGame);
    }

    @And("The User clicks on KidsToys-Party category")
    public void theUserClicksOnKidsToys_PartyCategory() {
        c.clickFunc(c.kidsToysParty);
        wait.until(ExpectedConditions.visibilityOf(c.chooseLocation));
        c.clickFunc(c.chooseLocation);
        c.clickFunc(c.city);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        c.clickFunc(c.optionCity);
        c.clickFunc(c.District);
        c.clickFunc(c.optionDistrict);
        c.clickFunc(c.selectLocation);


    }

    @And("The User selects Location-Specific Delivery")
    public void theUserSelectsLocationSpecificDelivery() {

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='local-special-checkbox']")));
        c.clickFunc(c.locationSpesificDelivery);


    }
    @And("The User checks the location-specific price of the product")
    public void theUserChecksTheLocationSpecificPriceOfTheProduct() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.newPrice.cPoint.priceEventClick > ins")));
        JavascriptExecutor js = (JavascriptExecutor) PageDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",c.firstProductPrice);
          js.executeScript("window.scrollBy(0, 200);");
        String konumaOzelFiyat=c.firstProductPrice.getText();
        System.out.println("Konuma Özel Fiyat="+konumaOzelFiyat);
    }

    @When("The User adds the product in the cart")
    public void theUserAddsTheProductInTheCart() {
        c.clickFunc(c.addToCart);


    }

    @Then("The user goes to the cart")
    public void theUserGoesToTheCart() {
        c.clickFunc(c.goToCart);
      //  c.clickFunc(c.kvkk);


    }

    @And("The User compares the location-specific price with the price in the cart")
    public void theUserComparesTheLocationSpecificPriceWithThePriceInTheCart() {
       String KonumaOzelFiyat= "3.689,00";
        String sepettekiFiyat =c.priceInCart.getText();
        System.out.println("Sepetteki Fiyat :"+sepettekiFiyat);
       Assert.assertNotEquals("Liste Fiyatı ile sepetteki fiyat aynı olmamalı!",KonumaOzelFiyat,sepettekiFiyat);


    }

    @When("The user removes the product from the cart")
    public void the_user_removes_the_product_from_the_cart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.removeProd")));
        c.clickFunc(c.removeProduct);
        c.clickFunc(c.delete);


    }

    @Then("Verify the cart is empty")
    public void verifyTheCartIsEmpty() {
        c.verifyContainsTextFunction(c.empty,"Sepetin Boş Görünüyor");
    }

    @And("Logout on the website")
    public void logoutOnTheWebsite() {
        Actions actions=new Actions(PageDriver.getDriver());
        actions.moveToElement(c.myAccount).build().perform();
        c.clickFunc(c.logoutBtn);

    }
}
