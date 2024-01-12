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

    @FindBy(xpath = "(//input[@value='Add to Cart'][1])")
    public WebElement Product_1_AddToCart;
    @FindBy(xpath = "(//input[@value='Add to Cart'][2])")
    public WebElement Product_2_AddToCart;
    @FindBy(xpath = "(//input[@value='Add to Cart'][3])")
    public WebElement Product_3_AddToCart;
    @FindBy(xpath = "(//input[@value='Add to Cart'][4])")
    public WebElement Product_4_AddToCart;

//burada eklenen ürünün sirayla numara verilmeli


    @FindBy(xpath = "//a[.='product comparison']")
    public WebElement product_Comparison_Alert;

    @FindBy(xpath = "//h1[.='Product Comparison']")
    public WebElement product_Comparison_assert;
}
