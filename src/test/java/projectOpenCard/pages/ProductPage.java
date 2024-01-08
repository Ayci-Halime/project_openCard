package projectOpenCard.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import projectOpenCard.utilities.DriverThreadLocal;

import java.util.List;

public class ProductPage {
    public ProductPage() {

        PageFactory.initElements(DriverThreadLocal.getDriver(), this);
    }




    @FindBy(linkText = "Desktops")
    public WebElement desktops;    // buraya mouse move to yapmak lazım. hover için

    @FindBy(linkText = "Show All Desktops")
    public WebElement showAllDesktops;   // hover ile buraya gelip tıkla

    @FindBy(tagName = "h4")
    public List<WebElement> allProductsName;  // liste şeklinde 12 tane ürünün isimlerine tıklama yaparak ürünün sayfasına girebiliriz


    @FindBy(xpath = "//span[.='Add to Cart']")
    public List<WebElement> addToCartButton;  // liste şeklindeki 12 tane ürünün add to cart buttonuna tıklarız

    @FindBy(css = "button[onclick*='wishlist']")
    public List<WebElement> addToWishlistButton;  // liste şeklindeki 12 tane ürünün favoriye ekle buttonuna tıklarız


    @FindBy(css = "button[onclick*='compare']")
    public List<WebElement> compareButton;  // liste şeklindeki 12 tane ürünün karışlaştırma buttonuna tıklarız




    // buradan itibaren olan locate'ler her bir ürünün tıkladıktan sonra gelen ürün sayfasındaki her üründe aynı geçerli olan locateler

    @FindBy(css = "button[onclick*='wishlist']")
    public WebElement addToWishButtonInProduct;

    @FindBy(css = "button[onclick*='compare']")
    public WebElement compareButtonInProduct;

    @FindBy(tagName = "(h2)[2]")
    public WebElement priceInProduct;   // ürünlerdeki fiyatı gösterir

    @FindBy(xpath = "(//ul[@class='list-unstyled'])[9]/child::li/span")
    public WebElement originalPriceInProduct;  // indirim uygulanmış ürünlerdeki orjinal fiyatı bulur

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement qtyFieldInProduct;  // bu locate ile ürünü adedini seçebiliriz

    @FindBy(xpath = "//button[@id='button-cart']")
    public WebElement addToCartButtonInProduct;


    @FindBy(xpath = "(//a[@data-toggle='tab'])[2]")
    public WebElement reviewsSection;


    @FindBy(linkText = "Write a review")  // add to cart butonun altındaki write a review locate
    public WebElement writeReviewUnderAddToCartButton;


    @FindBy(xpath = "//input[@id='input-name']")
    public WebElement nameFieldInReviews;


    @FindBy(xpath = "//textarea[@id='input-review']")
    public WebElement textFieldInReviews;


    @FindBy(xpath = "//input[@value='1']")
    public WebElement ratingRadioButton1; //rating radio button daki ilk seçenek

    @FindBy(xpath = "//input[@value='2']")
    public WebElement ratingRadioButton2; //rating radio button daki ikinci seçenek

    @FindBy(xpath = "//input[@value='3']")
    public WebElement ratingRadioButton3;  //rating radio button daki üçüncü seçenek

    @FindBy(xpath = "//input[@value='4']")
    public WebElement ratingRadioButton4;  //rating radio button daki dördüncü seçenek

    @FindBy(xpath = "//input[@value='5']")
    public WebElement ratingRadioButton5;  //rating radio button daki beşinci seçenek

    @FindBy(xpath = "//button[@id='button-review']")
    public WebElement continueButtonInReview;


    @FindBy(xpath = "//div[@id='review']//following::div")
    public WebElement reviewConfirmationText;  // bu locate'in text ini al. "submitted" içerip içermediğini kontrol et


    @FindBy(xpath = "(//a[@data-toggle='tab'])[2]")
    public WebElement viewAllReviews;  // bu locate ile yazılan bütün yorumları confirm et. Eğer .contains("0") ise yazılan yorumlar gözükmüyor demektir


    @FindBy(xpath = "(//ul[@class='list-unstyled'])[8]/child::li")
    public List<WebElement> stockAvailability;  // Liste'nin size'ını alalım. Eğer size 4 ise, 4 üncü eleman; 3 ise 3'üncü eleman bize stok durumunu bildirir.


    public void showAllDesktops(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).perform();
        actions.click(showAllDesktops).perform();


    }

}
