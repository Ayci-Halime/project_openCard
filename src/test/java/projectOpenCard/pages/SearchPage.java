package projectOpenCard.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

public class SearchPage {
    public SearchPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='caption']//h4")
    public WebElement product_hd;
    @FindBy(xpath = "(//div[@class='caption']//h4)[1]")
    public WebElement product_samsung_syn;
    @FindBy(xpath = "(//div[@class='caption']//h4)[2]")
    public WebElement product_samsung_galaxy;

    @FindBy(xpath = "//div[@class='caption']//h4")
    public WebElement puroduct_nicon_D300;

    @FindBy(xpath = "(//p)[3]")
    public WebElement criteria_text;


    @FindBy(xpath = "//div[@class='caption']//h4")
    public WebElement product_samsung_tab;


    //Search
    @FindBy(xpath = "(//ul[@class='breadcrumb']//li)[2]")
    public WebElement search_page;
    @FindBy(id = "input-search")
    public WebElement search_keyword_input;

    @FindBy(xpath = "//select[@name='category_id']")
    public WebElement category_select;
    @FindBy(id = "button-search")
    public WebElement searchButton;
}
