package projectOpenCard.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import projectOpenCard.pages.HomePage;
import projectOpenCard.pages.ProductPage;

public class ReusableMethods {

    public static void selectProductMethod (int i) {
        ProductPage productPage = new ProductPage();
        productPage.allProductsName.get(i).click();  // bütün ürünler listede olduğu için, bu metod ile istenilen ürüne tıklama yapılabilir

    }

    public static void showAllDesktopMethod(WebDriver driver) {

        Actions actions = new Actions(driver);
        HomePage homePage = new HomePage();
        actions.moveToElement(homePage.desktops).perform();
        actions.click(homePage.showAllDesktops).perform();

    }
    public static void login(WebDriver driver) {

        driver.get(ConfigReader.getProperty("login_url"));
        driver.findElement(By.id("input-email")).sendKeys(ConfigReader.getProperty("login_email"));
        driver.findElement(By.id("input-password")).sendKeys(ConfigReader.getProperty("login_password"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }



}
