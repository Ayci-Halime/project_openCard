package projectOpenCard.pages;

import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class WishListPage {
    public WishListPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
}
