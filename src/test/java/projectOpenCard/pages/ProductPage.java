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

    @FindBy(xpath = "//div[@class='image']")
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
    public WebElement addToCartButtonInProduct; // bu locate ile ürünü alışveriş sepetine ekleriz


    @FindBy(xpath = "//a[@data-toggle='tab']")
    public List<WebElement> reviewsSection;


    @FindBy(linkText = "Write a review")  // add to cart butonun altındaki write a review locate
    public WebElement writeReviewUnderAddToCartButton;


    @FindBy(xpath = "//input[@id='input-name']")
    public WebElement nameFieldInReviews;


    @FindBy(xpath = "//textarea[@id='input-review']")
    public WebElement textFieldInReviews;

    @FindBy(xpath = "//div[@id='review']//following::div")
    public WebElement errorMessageInReview;




    @FindBy(xpath = "//input[@name='rating']")
    public List<WebElement> ratingRadioButtons; //Liste olarak 5 tane buton seçeneği dönüyor



    @FindBy(xpath = "//button[@id='button-review']")
    public WebElement continueButtonInReview;


    @FindBy(xpath = "//div[text()=' Thank you for your review. It has been submitted to the webmaster for approval.']")
    public WebElement reviewConfirmationText;  // bu locate'in text ini al. "submitted" içerip içermediğini kontrol et


    @FindBy(xpath = "//a[@data-toggle='tab']")
    public List<WebElement> viewAllReviews;  // bu locate ile yazılan bütün yorumları confirm et. Eğer .contains("0") ise yazılan yorumlar gözükmüyor demektir


    @FindBy(xpath = "(//ul[@class='list-unstyled'])[8]/child::li")
    public List<WebElement> stockAvailability;  // Liste'nin size'ını alalım. Eğer size 4 ise, 4 üncü eleman; 3 ise 3'üncü eleman bize stok durumunu bildirir.


    public void showAllDesktopMethod(WebDriver driver) {

        Actions actions = new Actions(driver);
        actions.moveToElement(desktops).perform();
        actions.click(showAllDesktops).perform();

    }

    public void selectProductMethod (int i) {
        allProductsName.get(i).click();  // bütün ürünler listede olduğu için, bu metod ile istenilen ürüne tıklama yapılabilir

    }

    public void addToCartMethod (int i) {
        addToCartButton.get(i).click();  // cart butonları liste de olduğu için, metod ile istenilen indexteki ürüne ait butona tıklanabilir

    }

    public void addToWishListMethod (int i) {
       addToWishlistButton.get(i).click(); // wish butonları liste de olduğu için, metod ile istenilen indexteki ürüne ait butona tıklanabilir

    }

    public void compareProductMethod (int i) {
        compareButton.get(i).click(); // compare butonları liste de olduğu için, metod ile istenilen indexteki ürüne ait butona tıklanabilir

    }

    public void clickOnRatingRadioButtonMethod(int i) {
        ratingRadioButtons.get(i).click();

    }

    public void clickOnReviewSectionMethod() {
        if(reviewsSection.size() == 3) {
            reviewsSection.get(2).click();
        }
        if (reviewsSection.size() == 2) {
            reviewsSection.get(1).click();
        }
    }

    public WebElement viewAllReviewsMethod() {
        WebElement element = null;
        if(viewAllReviews.size() == 3) {
            viewAllReviews.get(2).click();
            element = viewAllReviews.get(2);
        }
        if (viewAllReviews.size() == 2) {
            viewAllReviews.get(1).click();
            element = viewAllReviews.get(1);
        }
        return element;
    }



}
