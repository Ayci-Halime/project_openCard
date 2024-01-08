package projectOpenCard.pages;

import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class LoginPage {
    public LoginPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
}
