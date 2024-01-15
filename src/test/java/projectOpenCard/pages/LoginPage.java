package projectOpenCard.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
    @FindBy(xpath = "//h2[text()='My Account']")
    public WebElement Myaccount;
}
