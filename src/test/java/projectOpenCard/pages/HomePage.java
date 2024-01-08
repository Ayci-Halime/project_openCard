package projectOpenCard.pages;

import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class HomePage {
    public HomePage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }

}
