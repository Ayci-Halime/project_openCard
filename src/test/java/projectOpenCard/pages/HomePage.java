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

    @FindBy(linkText = "Desktops")
    public WebElement desktops;

    @FindBy(linkText = "Laptops & Notebooks")
    public WebElement laptopsNotebooks;

    @FindBy(linkText = "Components")
    public WebElement components;

    @FindBy( tagName= "h2")
    public WebElement dogrulamaMesaji;

    @FindBy(linkText="Show All Desktops")
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








}
