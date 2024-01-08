package projectOpenCard.pages;

import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class SearchPage {
    public SearchPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
}
