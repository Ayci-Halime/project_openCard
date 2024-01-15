package projectOpenCard.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class ShoppingCartPage {
    public ShoppingCartPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);

    }
    @FindBy(xpath = "(//div[@class='product-thumb']//div//div//button)[1]")
    public WebElement samsungTablet;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement warningAlert;
}
