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






}
