package projectOpenCard.utilities;

import org.openqa.selenium.WebDriver;
import projectOpenCard.pages.ProductPage;

public class ReusableMethods {

    public static void selectProductMethod (int i) {
        ProductPage productPage = new ProductPage();
        productPage.allProductsName.get(i).click();  // bütün ürünler listede olduğu için, bu metod ile istenilen ürüne tıklama yapılabilir

    }



}
