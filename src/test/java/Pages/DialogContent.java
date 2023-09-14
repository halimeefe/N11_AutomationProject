package Pages;

import Utilities.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parent {


    public DialogContent() {
        PageFactory.initElements(PageDriver.getDriver(), this);

    }

    @FindBy (css = "button[class='dn-slide-deny-btn']")
    public WebElement later;

    @FindBy (css = "[title='Kitap, Müzik, Film, Oyun']")
    public WebElement bookMusicFilmGame;

    @FindBy (xpath = "(//*[text()='Çocuk Oyuncakları & Parti'])[2]")
    public WebElement kidsToysParty;


    @FindBy (css = "[class='filter-place-switch-box']")
    public WebElement chooseLocation;

    @FindBy (name = "cityId")
    public WebElement city;

    @FindBy (xpath = "//select[@name='cityId']/option[@value='2534']")
    public WebElement optionCity;

    @FindBy (name = "districtId")
    public WebElement District;

    @FindBy (xpath = "//select[@name='districtId']/option[@value='22350']")
    public WebElement optionDistrict;

    @FindBy (id = "headerSetMyLocationBtn")
    public WebElement selectLocation;


    @FindBy (css = "label[for='local-special-checkbox']")
    public  WebElement locationSpesificDelivery;

    @FindBy (css = "span.newPrice.cPoint.priceEventClick > ins")
    public WebElement firstProductPrice;

    @FindBy (css = "[class='btnBasket']")
    public WebElement addToCart;

    @FindBy (css = "[class='myBasket basket-icon custom-icon']")
    public WebElement goToCart;

    @FindBy (xpath = "(//*[@class='closeBtn'])[5]")
    public WebElement kvkk;

    @FindBy (css = "[class='dtl total'] >span + span")
    public WebElement priceInCart;

    @FindBy (css = "span.removeProd ")
    public WebElement removeProduct;

    @FindBy (className = "btnSignIn")
    public WebElement login;

    @FindBy (css = "[id='email']")
    public WebElement inputUsername;

    @FindBy (css = "[id='password']")
    public WebElement inputPassword;

    @FindBy (id = "loginButton")
    public WebElement loginButton;

    @FindBy (id = "deleteBtnDFLB")
   public WebElement delete;

     @FindBy (xpath="//*[text()='Sepetin Boş Görünüyor']")
   public WebElement empty;

     @FindBy (className = "user")
    public WebElement myAccount;

     @FindBy (css = "[class='hOpenMenuContent']>a:nth-child(10)")
    public WebElement logoutBtn;


}
