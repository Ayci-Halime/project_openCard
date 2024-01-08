package projectOpenCard.pages;

import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class ProductComparisonPage {
    public ProductComparisonPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
}
