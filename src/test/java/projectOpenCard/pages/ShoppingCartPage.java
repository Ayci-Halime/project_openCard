package projectOpenCard.pages;

import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class ShoppingCartPage {
    public ShoppingCartPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
}
