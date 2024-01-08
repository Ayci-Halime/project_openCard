package projectOpenCard.pages;

import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class ProductPage {
    public ProductPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
}
