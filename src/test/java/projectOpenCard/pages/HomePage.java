package projectOpenCard.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

import java.util.List;

public class HomePage {
    public HomePage() {


        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
    @FindBy(xpath = "//ul[@class='list-inline']/child::li")
    public List<WebElement> ustMenu;
    //List donduruyor; 1.index ecount 2.index wishlist 3.index shoppingCart

    @FindBy(linkText = "//a[text()='Desktops']")
    public WebElement desktops;

    @FindBy(linkText = "Laptops & Notebooks")
    public WebElement laptopsNotebooks;

    @FindBy(linkText = "Components")
    public WebElement components;

    @FindBy( tagName= "h2")
    public WebElement dogrulamaMesaji;

    @FindBy(linkText="/a[text()='Show All Desktops']")
    public WebElement showAllDesktops;


    @FindBy(linkText="Tablets")
    public WebElement tablets;

    @FindBy(linkText="Software")
    public WebElement software;

    @FindBy(linkText="Phones & PDAs")
    public WebElement phonesAndPDAs;

    @FindBy(linkText="Cameras")
    public WebElement cameras;

    @FindBy(linkText="MP3 Players")
    public WebElement mp3Players;

    @FindBy(xpath="//input[@name='search']")
    public WebElement searchBox;

    @FindBy(xpath="(//button[@type='button'])[4]")
    public WebElement searchIcon;

    @FindBy(xpath="//div[@id='cart']//child::button")
    public WebElement items;

    @FindBy(id="wishlist-total")
    public WebElement wishList;

    @FindBy(xpath="//span[text()='My Account']")
    public WebElement myAccount;

    //   @FindBy(linkText = "My Account") yukardaki ile ayni islem

    @FindBy(xpath="//span[text()='Shopping Cart']")
    public WebElement shoppingCart;

    @FindBy(xpath="//a[text()='Register']")
    public WebElement myAccountRegister;

    @FindBy(xpath="//a[text()='Login']")
    public WebElement myAccountLogin;






}
