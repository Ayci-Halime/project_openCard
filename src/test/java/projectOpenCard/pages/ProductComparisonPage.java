package projectOpenCard.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class ProductComparisonPage {
    public ProductComparisonPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }
    @FindBy(id = "compare-total")
    public WebElement ProductCompare;

    @FindBy(xpath = "//a[text()='product comparison']")
    public WebElement productComparison;

    @FindBy(xpath = "//input[@class='btn btn-primary btn-block']")
    public WebElement Product_8_AddToCart;
//burada eklenen ürünün sirayla numara verilmeli

}
