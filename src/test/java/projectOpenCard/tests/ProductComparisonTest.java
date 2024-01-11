package projectOpenCard.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import projectOpenCard.pages.ProductPage;
import projectOpenCard.utilities.ConfigReader;
import projectOpenCard.utilities.DriverThreadLocal;
import projectOpenCard.utilities.ReusableMethods;

import static org.testng.Assert.assertTrue;

public class ProductComparisonTest {


    @Test
    public void testProductComparison_Button(){
        DriverThreadLocal.setDriver();
        WebDriver driver = DriverThreadLocal.getDriver();
        ProductPage productPage=new ProductPage();

        driver.get(ConfigReader.getProperty("automationlabs_homepage_url"));

        ReusableMethods.showAllDesktopMethod(driver);
        assertTrue(productPage.compareButton.get(0).isDisplayed());
        driver.quit();
    }
}
